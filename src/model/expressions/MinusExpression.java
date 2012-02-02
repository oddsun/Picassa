package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;


public class MinusExpression extends TwoOperandSymmetricCmdExpression {
	
	public MinusExpression(ArrayList<Expression> operands) {
		super("minus", operands);
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return a - b;
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new MinusExpression(operands);
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new MinusExpression(null));
	}
}
