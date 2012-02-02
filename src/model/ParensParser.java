package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.expressions.*;
import model.factory.ExpressionFactory;

public class ParensParser extends Parser {

	// expression begins with a left paren followed by the command name,
	// which is a sequence of alphabetic characters
	private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
			.compile("\\(([a-zA-Z]+)");
	
	private ArrayList<ExpressionFactory> myFactoryObject;

	public ParensParser()
	{
		initialize();
	}
	
	public void initialize() {
		myFactoryObject = new ArrayList<ExpressionFactory>();
		myFactoryObject.add(ColorExpression.getFactory());
		myFactoryObject.add(DivExpression.getFactory());
		myFactoryObject.add(ExpExpression.getFactory());
		myFactoryObject.add(MinusExpression.getFactory());
		myFactoryObject.add(ModExpression.getFactory());
		myFactoryObject.add(MulExpression.getFactory());
		myFactoryObject.add(NegExpression.getFactory());
		myFactoryObject.add(PlusExpression.getFactory());
		myFactoryObject.add(RandomExpression.getFactory());
		myFactoryObject.add(FloorExpression.getFactory());
		myFactoryObject.add(CeilExpression.getFactory());
		myFactoryObject.add(AbsExpression.getFactory());
		myFactoryObject.add(ClampExpression.getFactory());
		myFactoryObject.add(WrapExpression.getFactory());
		myFactoryObject.add(SinExpression.getFactory());
		myFactoryObject.add(CosExpression.getFactory());
		myFactoryObject.add(TanExpression.getFactory());
		myFactoryObject.add(ATanExpression.getFactory());
		myFactoryObject.add(RGBtoYCbCrExpression.getFactory());
		myFactoryObject.add(YCbCrtoRGBExpression.getFactory());
	}
	
	@Override
	public Expression parseExpression(ParserData data) {
		Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(data.myInput);
		expMatcher.find(data.myCurrentPosition);
		// System.out.println(currentCharacter());
		String commandName = expMatcher.group(1);
		data.myCurrentPosition = expMatcher.end();
		ArrayList<Expression> myOperands = new ArrayList<Expression>();
		skipWhiteSpace(data);
		while(currentCharacter(data) != ')')
		{
			if (data.myCurrentPosition == data.myInput.length() - 1)
				throw new ParserException("Expected close paren!");
			myOperands.add(ParserMediator.parseParser(data));	
			skipWhiteSpace(data);
		}
		data.myCurrentPosition++;
			// System.out.println(commandName);
		for(ExpressionFactory factory : myFactoryObject)
		{
			if(factory.isThisExpression(commandName))
				return factory.createExpression(myOperands);
		}
		throw new ParserException("Unknown Command "
				+ commandName, ParserException.Type.UNKNOWN_COMMAND);
	}

	@Override
	public boolean isThisParser(ParserData data) {
		return EXPRESSION_BEGIN_REGEX.matcher(data.myInput.substring(data.myCurrentPosition)).lookingAt();
	}

	
}
