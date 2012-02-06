package model.expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinColorExpression extends ParensExpression {

	public PerlinColorExpression(ArrayList<Expression> operands) {
		super(operands, "perlinColor");
		// TODO Auto-generated constructor stub
	}

	private static final int DEFAULT_NUM_OPERANDS = 2;
	
	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		check(DEFAULT_NUM_OPERANDS, operandColors.size());
		RGBColor left = operandColors.get(0);
		RGBColor right = operandColors.get(1);
		return PerlinNoise.colorNoise(left, right);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new PerlinColorExpression(null));
	}

}
