package model.expressions;

import java.util.ArrayList;


public class LogExpression extends OneOperandSymmetricCmdExpression {

	public LogExpression(ArrayList<Expression> operands) {
		super(operands, "log");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double symmetricCalculate(double a) {
		return Math.log(a);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new LogExpression(null));
	}

}
