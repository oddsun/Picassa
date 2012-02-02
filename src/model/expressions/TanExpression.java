package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;

public class TanExpression extends OneOperandSymmetricCmdExpression {

	public TanExpression(ArrayList<Expression> operands) {
		super("tan", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.tan(a);
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new TanExpression(operands);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new TanExpression(null));
	}

}
