package model.expressions;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.ParserData;
import model.ParserException;
import model.RGBColor;


public abstract class ParensExpression extends Expression {
	private String[] myCmd;
	protected ArrayList<Expression> myOperands;
	private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
			.compile("\\(([a-zA-Z+*-/%^!]+)");
	
	public ParensExpression(ArrayList<Expression> operands, String ... cmd) {
		myCmd = cmd;
		myOperands = operands;
	}
	
	public Expression parseExpression(ParserData data) {
		ArrayList<Expression> operands = new ArrayList<Expression>();
		data.skipWhiteSpace();
		while(data.currentCharacter() != ')')
		{
			if (data.myCurrentPosition == data.myInput.length() - 1)
				throw new ParserException("Expected close paren!");
			operands.add(data.parseParser());
			data.skipWhiteSpace();
		}
		data.myCurrentPosition++;
		return create(operands);
	}
	
	public abstract ParensExpression create(ArrayList<Expression> operands);
	
	public boolean canParse(ParserData data) {
		Matcher exMatcher = EXPRESSION_BEGIN_REGEX.matcher(data.myInput);
		if(exMatcher.find(data.myCurrentPosition))
		{
			String commandName = exMatcher.group(1);
			for(String cmd : myCmd)
			{
				if(commandName.equals(cmd))
				{
					data.myCurrentPosition = exMatcher.end();
					data.skipWhiteSpace();
					return true;
				}
			}
		}
		return false;
	}
	
	public void check(int reqNumOperands, int size)
	{
		if (size != reqNumOperands)
			throw new ParserException(
			"Wrong number of operands!!! :( operands exprected: " + reqNumOperands + " , got: " + size);
	}
	
	@Override
	public RGBColor evaluate(Map<String, ArrayList<RGBColor>> variables)
	{
		ArrayList<RGBColor> myOperandColors = new ArrayList<RGBColor>();
		for(Expression Operand : myOperands)
		{
			myOperandColors.add(Operand.evaluate(variables));
		}
		return calculate(myOperandColors);
	}
	
	public abstract RGBColor calculate(ArrayList<RGBColor> operandColors);

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("( ");
		result.append(myCmd);
		for (Expression exp : myOperands) {
			result.append(exp);
		}
		result.append(")");
		return result.toString();
	}
}

