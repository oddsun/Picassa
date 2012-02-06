package model.expressions;

import java.util.ArrayList;



public class DivExpression extends TwoOperandSymmetricCmdExpression {
	
	public DivExpression(ArrayList<Expression> operands) {
		super(operands, "div", "/");
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return a / b;
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new DivExpression(null));
	}
}
