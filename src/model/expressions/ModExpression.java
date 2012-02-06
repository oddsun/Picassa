package model.expressions;

import java.util.ArrayList;



public class ModExpression extends TwoOperandSymmetricCmdExpression {
	
	public ModExpression(ArrayList<Expression> operands) {
		super(operands, "mod", "%");
	}

	@Override
	public double symmetricCalculate(double a, double b) {
		return a % b;
	}

	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new ModExpression(null));
	}
	
}
