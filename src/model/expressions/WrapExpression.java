package model.expressions;

import java.util.ArrayList;

import model.RGBColor;


public class WrapExpression extends OneOperandSymmetricCmdExpression {

	public WrapExpression(ArrayList<Expression> operands) {
		super(operands, "wrap");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return new RGBColor().wrap(a);
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new WrapExpression(operands);
	}

}
