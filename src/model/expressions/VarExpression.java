package model.expressions;

import model.RGBColor;

public abstract class VarExpression extends Expression {

	public VarExpression(){}
	
//	private boolean isX, isY;

//	public VarExpression(boolean x, boolean y) {
//		isX = x;
//		isY = y;
//	}
//
//	public VarExpression(String xyMatch) {
//		isX = xyMatch.equals("x");
//		isY = xyMatch.equals("y");
//	}

	public boolean varMatching(String varMatcher, String var)
	{
		return varMatcher.equals(var);
	}
	
	public abstract boolean isThisVar(String varMatcher);
	
	@Override
	public abstract RGBColor evaluate(double x, double y);

	@Override
	public abstract String toString();
}
