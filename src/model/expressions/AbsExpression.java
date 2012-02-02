package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;

public class AbsExpression extends OneOperandSymmetricCmdExpression {

	public AbsExpression(ArrayList<Expression> operands) {
		super("abs", operands);
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.abs(a);
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new AbsExpression(operands);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new AbsExpression(null));
	}

}
