package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;

public class ClampExpression extends OneOperandSymmetricCmdExpression {

	public ClampExpression(ArrayList<Expression> operands) {
		super("clamp", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		if(a > 1)
			return 1;
		if(a < -1)
			return -1;
		return a;
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new ClampExpression(operands);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new ClampExpression(null));
	}

}
