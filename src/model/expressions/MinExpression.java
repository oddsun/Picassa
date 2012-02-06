package model.expressions;

import java.util.ArrayList;

import model.RGBColor;

public class MinExpression extends ParensExpression {

	public MinExpression(ArrayList<Expression> operands) {
		super(operands, "min");
		// TODO Auto-generated constructor stub
	}

	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
//		if(DEFAULT_NUM_OPERANDS > operandColors.size())
//			check(DEFAULT_NUM_OPERANDS, operandColors.size()); //may need to check operandColors size instead
		double min = 999, red = 0, blue = 0, green = 0;
		for(RGBColor color : operandColors)
		{
			if(color.average() < min)
			{
				min = color.average();
				red = color.getRed();
				green = color.getGreen();
				blue = color.getBlue();
			}
		}
		return new RGBColor(red, green, blue);
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new MinExpression(operands);
	}

}
