package model.expressions;

import model.RGBColor;

public class YVarExpression extends VarExpression{

	private static final String var = "y";
	
	public YVarExpression() {
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return new RGBColor(y);
	}

	@Override
	public String toString() {
		return " y";
	}

	@Override
	public boolean isThisVar(String varMatcher) {
		return varMatching(varMatcher, var);
	}
}