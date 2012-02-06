package model.expressions;

import java.util.ArrayList;


public class WrapExpression extends OneOperandSymmetricCmdExpression {

	public WrapExpression(ArrayList<Expression> operands) {
		super(operands, "wrap");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		if(a > 1)
			return symmetricCalculate(-2 + a);
		if(a < -1)
			return symmetricCalculate(2 + a);
		return a;
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new WrapExpression(operands);
	}

}
