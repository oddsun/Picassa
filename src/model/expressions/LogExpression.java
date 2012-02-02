package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;

public class LogExpression extends OneOperandSymmetricCmdExpression {

	public LogExpression(ArrayList<Expression> operands) {
		super("log", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.log(a);
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new LogExpression(operands);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new LogExpression(null));
	}

}
