package model.expressions;

import java.util.ArrayList;


public class SinExpression extends OneOperandSymmetricCmdExpression {

	public SinExpression(ArrayList<Expression> operands) {
		super(operands, "sin");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.sin(a);
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new SinExpression(operands);
	}

}
