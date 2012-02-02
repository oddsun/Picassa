package model.expressions;

import java.util.ArrayList;


import model.RGBColor;
import model.factory.ExpressionFactory;

public class ColorExpression extends CmdExpression {

	public final static int DEFAULT_NUM_OPERANDS = 3;
	
	public ColorExpression(ArrayList<Expression> operands) {
		super("color", operands);
	}

	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		check(DEFAULT_NUM_OPERANDS, operandColors.size());
		RGBColor left = operandColors.get(0);
		RGBColor middle = operandColors.get(1);
		RGBColor right = operandColors.get(2);
		return new RGBColor(left.getRed(), middle.getGreen(), right.getBlue());
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new ColorExpression(operands);
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new ColorExpression(null));
	}
}
