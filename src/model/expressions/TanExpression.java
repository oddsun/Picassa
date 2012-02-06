package model.expressions;

import java.util.ArrayList;


public class TanExpression extends OneOperandSymmetricCmdExpression {

	public TanExpression(ArrayList<Expression> operands) {
		super(operands, "tan");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.tan(a);
	}

	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new TanExpression(null));
	}

}
