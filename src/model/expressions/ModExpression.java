package model.expressions;

import java.util.ArrayList;

import model.factory.ExpressionFactory;


public class ModExpression extends TwoOperandSymmetricCmdExpression {
	
	public ModExpression(ArrayList<Expression> operands) {
		super("mod", operands);
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return a % b;
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new ModExpression(operands);
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new ModExpression(null));
	}
	
}
