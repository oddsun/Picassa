package model.expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.factory.ExpressionFactory;

public class YCbCrtoRGBExpression extends CmdExpression {

	private static final int DEFAULT_NUM_OPERANDS = 1;

	public YCbCrtoRGBExpression(ArrayList<Expression> operands) {
		super("yCrCbtoRGB", operands);
	}

	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		check(DEFAULT_NUM_OPERANDS, operandColors.size());
		RGBColor color = operandColors.get(0);
		return color.yCbCrtoRGB();
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new YCbCrtoRGBExpression(operands);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new YCbCrtoRGBExpression(null));
	}

}
