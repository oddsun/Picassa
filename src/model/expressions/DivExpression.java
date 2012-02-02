package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;


public class DivExpression extends TwoOperandSymmetricCmdExpression {
	
	public DivExpression(ArrayList<Expression> operands) {
		super("div", operands);
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return a / b;
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new DivExpression(operands);
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new DivExpression(null));
	}
}
