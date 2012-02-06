package model.expressions;

import java.util.ArrayList;



public class MinusExpression extends TwoPlusOperandSymmetricCmdExpression {
	
	public MinusExpression(ArrayList<Expression> operands) {
		super(operands, "minus", "-");
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return a - b;
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new MinusExpression(operands);
	}
}
