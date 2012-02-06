package model;

import java.util.ArrayList;

import model.expressions.*;

public class ParserMediator {
	
	private ArrayList<ExpressionFactory> myFactoryObject;
	
	public void initialize() {
		myFactoryObject = new ArrayList<ExpressionFactory>();
		myFactoryObject.add(NumberExpression.getFactory());
		myFactoryObject.add(VarExpression.getFactory());
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
		myFactoryObject.add(PerlinColorExpression.getFactory());
		myFactoryObject.add(PerlinBWExpression.getFactory());
		myFactoryObject.add(LetExpression.getFactory());
	}
	
	public Expression parseParser(ParserData data)
	{
		initialize();
		for(ExpressionFactory factory: myFactoryObject)
		{
			if(factory.isThisExpression(data))
				return factory.parseAndCreateExpression(data);
		}
		data.skipWhiteSpace();
		int pos = data.myInput.indexOf(" ", data.myCurrentPosition);
		String commandName = pos == -1 ? "" : data.myInput.substring(data.myCurrentPosition, pos);
		throw new ParserException("Unknown Command "
		+ commandName, ParserException.Type.UNKNOWN_COMMAND);
	}
	
	public Expression makeExpression(String input) {
		ParserData data = new ParserData (input, 0);
		Expression result = parseParser(data);
		data.skipWhiteSpace();
		if (data.notAtEndOfString()) {
			throw new ParserException(
					"Unexpected characters at end of the string: "
							+ data.myInput.substring(data.myCurrentPosition),
					ParserException.Type.EXTRA_CHARACTERS);
		}
		return result;
	}
}
