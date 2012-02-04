package model.expressions;

import model.RGBColor;

public class XVarExpression extends VarExpression{
	
//	private static final String var = "x";
	
	public XVarExpression() {
		super("x");
	}

	@Override
	public RGBColor evaluate(VariableData variables) {
		return new RGBColor(variables.x);
	}

//	@Override
//	public String toString() {
//		return " x";
//	}

	@Override
	public boolean isThisVar(String varMatcher) {
		return varMatching(varMatcher);
	}
}