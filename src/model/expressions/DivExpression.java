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

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new DivExpression(operands);
	}
}
