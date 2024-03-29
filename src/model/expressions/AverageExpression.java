package model.expressions;

import java.util.ArrayList;

import model.RGBColor;

public class AverageExpression extends ParensExpression {

	public AverageExpression(ArrayList<Expression> operands) {
		super(operands, "average");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
//		if(DEFAULT_NUM_OPERANDS > operandColors.size())
//			check(DEFAULT_NUM_OPERANDS, operandColors.size()); //may need to check operandColors size instead
		double red = 0, green = 0, blue = 0;
		int n = operandColors.size();
		for(RGBColor color : operandColors)
		{
			red += color.getRed() / n;
			green += color.getGreen() / n;
			blue += color.getBlue() / n;
		}
		return new RGBColor(red, green, blue);
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new AverageExpression(operands);
	}

}
