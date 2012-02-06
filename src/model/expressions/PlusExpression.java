package model.expressions;

import java.util.ArrayList;



public class PlusExpression extends TwoOperandSymmetricCmdExpression {
	
	public PlusExpression(ArrayList<Expression> operands) {
		super(operands, "plus", "+");
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return a + b;
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new PlusExpression(null));
	}
}
