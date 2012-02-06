package model.expressions;

import java.util.ArrayList;



public class PlusExpression extends TwoOperandSymmetricCmdExpression {
	
	protected final static int DEFAULT_NUM_OPERANDS = 2;
	
	public PlusExpression(ArrayList<Expression> operands) {
		super(operands, "plus", "+");
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
