package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;

public class FloorExpression extends OneOperandSymmetricCmdExpression {

	public FloorExpression(ArrayList<Expression> operands) {
		super("floor", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.floor(a);
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new FloorExpression(operands);
	}

	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new FloorExpression(null));
	}
	
}
