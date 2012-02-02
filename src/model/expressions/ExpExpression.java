package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;


public class ExpExpression extends TwoOperandSymmetricCmdExpression {
	
	public ExpExpression(ArrayList<Expression> operands) {
		super("exp", operands);
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return Math.pow(a, b);
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new ExpExpression(operands);
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new ExpExpression(null));
	}
}
