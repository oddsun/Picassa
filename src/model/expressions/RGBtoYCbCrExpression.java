package model.expressions;

import java.util.ArrayList;

import model.RGBColor;

public class RGBtoYCbCrExpression extends ParensExpression{

	private final static int DEFAULT_NUM_OPERANDS = 1;
	
	public RGBtoYCbCrExpression(ArrayList<Expression> operands) {
		super(operands, "rgbToYCrCb");
		// TODO Auto-generated constructor stub
	}

	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		check(DEFAULT_NUM_OPERANDS, operandColors.size());
		RGBColor color = operandColors.get(0);
		return color.rbgToYCbCr();
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new RGBtoYCbCrExpression(operands);
	}

}
