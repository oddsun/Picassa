package model.expressions;

import java.util.ArrayList;



public class ExpExpression extends TwoOperandSymmetricCmdExpression {
	
	public ExpExpression(ArrayList<Expression> operands) {
		super(operands, "exp", "^");
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return Math.pow(a, b);
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new ExpExpression(null));
	}
}
