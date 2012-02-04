package model.expressions;

import java.util.ArrayList;

import model.ParserException;
import model.RGBColor;
import model.factory.ExpressionFactory;


public abstract class CmdExpression extends Expression {
	private String myCmd;
	protected ArrayList<Expression> myOperands;

//	protected CmdExpression(){}
	
	public CmdExpression(String cmd, ArrayList<Expression> operands) {
		myCmd = cmd;
		myOperands = operands;
	}
	
	public void check(int reqNumOperands, int size)
	{
		if (size != reqNumOperands)
			throw new ParserException(
			"Wrong number of operands!!! :( operands exprected: " + reqNumOperands + " , got: " + size);
	}

	public String getCmd() {
		return myCmd;
	}
	
	@Override
	public RGBColor evaluate(VariableData variables)
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
	

	public abstract CmdExpression create(ArrayList<Expression> operands);
}

