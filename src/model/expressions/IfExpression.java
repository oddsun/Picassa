package model.expressions;

import java.util.ArrayList;

import model.RGBColor;

public class IfExpression extends ParensExpression {

	private static final int DEFAULT_NUM_OPERANDS = 3;
	
	public IfExpression(ArrayList<Expression> operands) {
		super(operands, "if");
		// TODO Auto-generated constructor stub
	}

	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		check(DEFAULT_NUM_OPERANDS, myOperands.size());
		RGBColor condition = operandColors.get(0);
		if(condition.average() > 0)
			return operandColors.get(1);
		return operandColors.get(2);
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new IfExpression(operands);
	}

}
