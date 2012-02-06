package model.expressions;

import java.util.ArrayList;

import model.RGBColor;

public class MaxExpression extends ParensExpression {

	public MaxExpression(ArrayList<Expression> operands) {
		super(operands, "max");
		// TODO Auto-generated constructor stub
	}

	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
//		if(DEFAULT_NUM_OPERANDS > operandColors.size())
//			check(DEFAULT_NUM_OPERANDS, operandColors.size()); //may need to check operandColors size instead
		double max = -999, red = 0, blue = 0, green = 0;
		for(RGBColor color : operandColors)
		{
			if(color.average() > max)
			{
				max = color.average();
				red = color.getRed();
				green = color.getGreen();
				blue = color.getBlue();
			}
		}
		return new RGBColor(red, green, blue);
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new MaxExpression(operands);
	}

}
