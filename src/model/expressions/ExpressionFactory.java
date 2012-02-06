package model.expressions;

import model.ParserData;


public class ExpressionFactory {
	private Expression myExpression;

	public ExpressionFactory(Expression exp) {
		myExpression = exp;
	}

	public boolean isThisExpression(ParserData data) {
		return myExpression.canParse(data);
	}

	public Expression parseAndCreateExpression(ParserData data) {
		return myExpression.parseExpression(data);
	}
}
