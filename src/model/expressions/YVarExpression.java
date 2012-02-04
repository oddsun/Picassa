package model.expressions;

import model.RGBColor;

public class YVarExpression extends VarExpression{

//	private static final String var = "y";
	
	public YVarExpression() {
		super("y");
	}

	@Override
	public RGBColor evaluate(VariableData variables) {
		return new RGBColor(variables.y);
	}

//	@Override
//	public String toString() {
//		return " y";
//	}

	@Override
	public boolean isThisVar(String varMatcher) {
		return varMatching(varMatcher);
	}
}