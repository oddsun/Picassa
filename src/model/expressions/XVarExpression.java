package model.expressions;

import model.RGBColor;

public class XVarExpression extends VarExpression{
	
	private static final String var = "x";
	
	public XVarExpression() {
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return new RGBColor(x);
	}

	@Override
	public String toString() {
		return " x";
	}

	@Override
	public boolean isThisVar(String varMatcher) {
		return varMatching(varMatcher, var);
	}
}