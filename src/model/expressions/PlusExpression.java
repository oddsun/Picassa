package model.expressions;

import java.util.ArrayList;

import model.RGBColor;



public class PlusExpression extends TwoPlusOperandSymmetricCmdExpression {
	
	protected final static int DEFAULT_NUM_OPERANDS = 2;
	
	public PlusExpression(ArrayList<Expression> operands) {
		super(operands, "plus", "+");
	}
	
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
//		if(DEFAULT_NUM_OPERANDS > operandColors.size())
//			check(DEFAULT_NUM_OPERANDS, operandColors.size()); //may need to check operandColors size instead
		double red = 0, green = 0, blue = 0;
		for(RGBColor color : operandColors)
		{
			red += color.getRed();
			green += color.getGreen();
			blue += color.getBlue();
		}
		return new RGBColor(red, green, blue);
	}
	
	@Override
	public double symmetricCalculate(double a, double b) {
		return a + b;
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new PlusExpression(operands);
	}
}
