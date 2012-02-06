package model.expressions;

import java.util.ArrayList;


public class NegExpression extends OneOperandSymmetricCmdExpression {
	
	public NegExpression(ArrayList<Expression> operands) {
		super(operands, "neg");
	}

	@Override
	public double symmetricCalculate(double a) {
		return -a;
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new NegExpression(null));
	}
}
