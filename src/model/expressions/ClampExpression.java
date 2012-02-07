package model.expressions;

import java.util.ArrayList;

import model.RGBColor;


public class ClampExpression extends OneOperandSymmetricCmdExpression {

	public ClampExpression(ArrayList<Expression> operands) {
		super(operands, "clamp");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return new RGBColor().clamp(a);
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new ClampExpression(operands);
	}

}
