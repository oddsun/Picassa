package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;

public class ATanExpression extends OneOperandSymmetricCmdExpression {

	public ATanExpression(ArrayList<Expression> operands) {
		super("atan", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.atan(a);
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new ATanExpression(operands);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new ATanExpression(null));
	}

}
