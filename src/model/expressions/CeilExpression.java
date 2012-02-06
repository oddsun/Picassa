package model.expressions;

import java.util.ArrayList;


public class CeilExpression extends OneOperandSymmetricCmdExpression {

	public CeilExpression(ArrayList<Expression> operands) {
		super(operands, "ceil");
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.ceil(a);
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new CeilExpression(operands);
	}

}
