package model.expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.factory.ExpressionFactory;

public class RGBtoYCbCrExpression extends CmdExpression{

	private final static int DEFAULT_NUM_OPERANDS = 1;
	
	public RGBtoYCbCrExpression(ArrayList<Expression> operands) {
		super("rgbToYCrCb", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new RGBtoYCbCrExpression(operands);
	}

	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		check(DEFAULT_NUM_OPERANDS, operandColors.size());
		RGBColor color = operandColors.get(0);
		return color.rbgToYCbCr();
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new RGBtoYCbCrExpression(null));
	}

}
