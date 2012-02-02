package model.factory;

import java.util.ArrayList;

import model.expressions.CmdExpression;
import model.expressions.Expression;


public class ExpressionFactory {
	private CmdExpression myExpression;

	public ExpressionFactory(CmdExpression exp) {
		myExpression = exp;
	}

	public boolean isThisExpression(String userCmd) {
		return userCmd.equals(myExpression.getCmd());
	}

	public CmdExpression createExpression(ArrayList<Expression> operands) {
		return myExpression.create(operands);
	}
}
