package model.expressions;

import java.util.ArrayList;


public class FloorExpression extends OneOperandSymmetricCmdExpression {

	public FloorExpression(ArrayList<Expression> operands) {
		super(operands, "floor");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.floor(a);
	}

	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new FloorExpression(null));
	}
	
}
