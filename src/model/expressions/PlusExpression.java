package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;


public class PlusExpression extends TwoOperandSymmetricCmdExpression {
	
	public PlusExpression(ArrayList<Expression> operands) {
		super("plus", operands);
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return a + b;
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new PlusExpression(operands);
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new PlusExpression(null));
	}
}
