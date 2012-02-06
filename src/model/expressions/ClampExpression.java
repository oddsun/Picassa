package model.expressions;

import java.util.ArrayList;


public class ClampExpression extends OneOperandSymmetricCmdExpression {

	public ClampExpression(ArrayList<Expression> operands) {
		super(operands, "clamp");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		if(a > 1)
			return 1;
		if(a < -1)
			return -1;
		return a;
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new ClampExpression(operands);
	}

}
