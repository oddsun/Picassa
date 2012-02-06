package model.expressions;

import java.util.ArrayList;

import model.RGBColor;

public class YCbCrtoRGBExpression extends ParensExpression {

	private static final int DEFAULT_NUM_OPERANDS = 1;

	public YCbCrtoRGBExpression(ArrayList<Expression> operands) {
		super(operands, "yCrCbtoRGB");
	}

	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		check(DEFAULT_NUM_OPERANDS, operandColors.size());
		RGBColor color = operandColors.get(0);
		return color.yCbCrtoRGB();
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new YCbCrtoRGBExpression(null));
	}

}
