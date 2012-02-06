package model.expressions;

import java.util.ArrayList;




public class MulExpression extends TwoOperandSymmetricCmdExpression {
	
	public MulExpression(ArrayList<Expression> operands) {
		super(operands, "mul", "*");
	}
	
	@Override
	public double symmetricCalculate(double a, double b) {
		return a * b;
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new MulExpression(operands)
;	}

}
