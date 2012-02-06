package model.expressions;

import java.util.ArrayList;


public class CosExpression extends OneOperandSymmetricCmdExpression {

	public CosExpression(ArrayList<Expression> operands) {
		super(operands, "cos");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.cos(a);
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new CosExpression(operands);
	}

}
