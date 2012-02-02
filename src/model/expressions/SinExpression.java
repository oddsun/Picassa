package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;

public class SinExpression extends OneOperandSymmetricCmdExpression {

	public SinExpression(ArrayList<Expression> operands) {
		super("sin", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.sin(a);
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new SinExpression(operands);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new SinExpression(null));
	}

}
