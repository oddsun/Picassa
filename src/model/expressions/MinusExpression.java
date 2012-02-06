package model.expressions;

import java.util.ArrayList;



public class MinusExpression extends TwoOperandSymmetricCmdExpression {
	
	public MinusExpression(ArrayList<Expression> operands) {
		super(operands, "minus", "-");
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return a - b;
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new MinusExpression(null));
	}
}
