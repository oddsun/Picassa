package model.expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.factory.ExpressionFactory;
import model.util.PerlinNoise;

public class PerlinBWExpression extends CmdExpression {

	public PerlinBWExpression(ArrayList<Expression> operands) {
		super("perlinColor", operands);
		// TODO Auto-generated constructor stub
	}

	private static final int DEFAULT_NUM_OPERANDS = 2;
	
	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		check(DEFAULT_NUM_OPERANDS, operandColors.size());
		RGBColor left = operandColors.get(0);
		RGBColor right = operandColors.get(1);
		return PerlinNoise.greyNoise(left, right);
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new PerlinBWExpression(operands);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new PerlinBWExpression(null));
	}

}