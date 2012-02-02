package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;

public class CosExpression extends OneOperandSymmetricCmdExpression {

	public CosExpression(ArrayList<Expression> operands) {
		super("cos", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.cos(a);
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new CosExpression(operands);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new CosExpression(null));
	}

}
