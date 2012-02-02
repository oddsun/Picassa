package model.expressions;

import java.util.ArrayList;


import model.RGBColor;
import model.factory.ExpressionFactory;
import model.util.ColorComputation;

public class NegExpression extends OneOperandSymmetricCmdExpression {
	
	public NegExpression(ArrayList<Expression> operands) {
		super("neg", operands);
	}

	@Override
	public double symmetricCalculate(double a) {
		return -a;
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new NegExpression(operands);
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new NegExpression(null));
	}
}
