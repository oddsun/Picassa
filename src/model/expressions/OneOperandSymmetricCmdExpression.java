package model.expressions;

import java.util.ArrayList;

import model.RGBColor;

public abstract class OneOperandSymmetricCmdExpression extends ParensExpression {

	protected final static int DEFAULT_NUM_OPERANDS = 1;
	
	public OneOperandSymmetricCmdExpression(ArrayList<Expression> operands, String ... cmd) {
		super(operands, cmd);
	}

	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		check(DEFAULT_NUM_OPERANDS, operandColors.size()); //may need to check operandColors size instead
		RGBColor color = operandColors.get(0);
		return new RGBColor(symmetricCalculate(color.getRed()),
		symmetricCalculate(color.getGreen()),
		symmetricCalculate(color.getBlue()));
	}
	
	public abstract double symmetricCalculate(double a);

}
