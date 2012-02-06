package model.expressions;

import java.util.ArrayList;



public class ModExpression extends TwoPlusOperandSymmetricCmdExpression {
	
	public ModExpression(ArrayList<Expression> operands) {
		super(operands, "mod", "%");
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return a % b;
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new ModExpression(operands);
	}
	
}
