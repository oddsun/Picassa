package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;


public class MulExpression extends TwoOperandSymmetricCmdExpression {
	
	public MulExpression(ArrayList<Expression> operands) {
		super("mul", operands);
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return a * b;
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new MulExpression(operands);
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new MulExpression(null));
	}

}
