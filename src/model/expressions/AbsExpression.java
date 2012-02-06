package model.expressions;

import java.util.ArrayList;


public class AbsExpression extends OneOperandSymmetricCmdExpression {

	public AbsExpression(ArrayList<Expression> operands) {
		super(operands, "abs");
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.abs(a);
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new AbsExpression(operands);
	}

}
