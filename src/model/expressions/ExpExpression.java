package model.expressions;

import java.util.ArrayList;



public class ExpExpression extends TwoPlusOperandSymmetricCmdExpression {
	
	public ExpExpression(ArrayList<Expression> operands) {
		super(operands, "exp", "^");
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return Math.pow(a, b);
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new ExpExpression(operands);
	}
}
