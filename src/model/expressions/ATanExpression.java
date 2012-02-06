package model.expressions;

import java.util.ArrayList;


public class ATanExpression extends OneOperandSymmetricCmdExpression {

	public ATanExpression(ArrayList<Expression> operands) {
		super(operands, "atan");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.atan(a);
	}

	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new ATanExpression(null));
	}

}
