package model.expressions;

import java.util.ArrayList;


public class AbsExpression extends OneOperandSymmetricCmdExpression {

	public AbsExpression(ArrayList<Expression> operands) {
		super(operands, "abs");
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.abs(a);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new AbsExpression(null));
	}

}
