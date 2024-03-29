package model.expressions;

import java.util.ArrayList;

import model.RGBColor;

public abstract class TwoOperandSymmetricCmdExpression extends ParensExpression {

	protected final static int DEFAULT_NUM_OPERANDS = 2;
	
	public TwoOperandSymmetricCmdExpression(ArrayList<Expression> operands, String ... cmd) {
		super(operands, cmd);
	}

	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		check(DEFAULT_NUM_OPERANDS, operandColors.size()); //may need to check operandColors size instead
		RGBColor left = operandColors.get(0);
		RGBColor right = operandColors.get(1);
		return new RGBColor(symmetricCalculate(left.getRed(),right.getRed()),
		symmetricCalculate(left.getGreen(), right.getGreen()),
		symmetricCalculate(left.getBlue(), right.getBlue()));
	}

	public abstract double symmetricCalculate(double a, double b);
}
