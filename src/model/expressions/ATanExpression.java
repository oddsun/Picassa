package model.expressions;

import java.util.ArrayList;


public class ATanExpression extends OneOperandSymmetricCmdExpression {

	public ATanExpression(ArrayList<Expression> operands) {
		super(operands, "atan");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.atan(a);
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new ATanExpression(operands);
	}

}
