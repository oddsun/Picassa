package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;

public class WrapExpression extends OneOperandSymmetricCmdExpression {

	public WrapExpression(ArrayList<Expression> operands) {
		super("wrap", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		if(a > 1)
			return symmetricCalculate(-2 + a);
		if(a < -1)
			return symmetricCalculate(2 + a);
		return a;
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new WrapExpression(operands);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new WrapExpression(null));
	}

}
