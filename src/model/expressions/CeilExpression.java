package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;

public class CeilExpression extends OneOperandSymmetricCmdExpression {

	public CeilExpression(ArrayList<Expression> operands) {
		super("ceil", operands);
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.ceil(a);
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new CeilExpression(operands);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new CeilExpression(null));
	}

}
