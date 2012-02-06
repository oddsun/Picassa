package model.expressions;

import java.util.ArrayList;



public class MulExpression extends TwoOperandSymmetricCmdExpression {
	
	public MulExpression(ArrayList<Expression> operands) {
		super(operands, "mul", "*");
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return a * b;
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new MulExpression(null));
	}

}
