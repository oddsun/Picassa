package model.expressions;

import java.util.ArrayList;


public class CeilExpression extends OneOperandSymmetricCmdExpression {

	public CeilExpression(ArrayList<Expression> operands) {
		super(operands, "ceil");
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.ceil(a);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new CeilExpression(null));
	}

}
