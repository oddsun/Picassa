package model.expressions;

import model.RGBColor;

public abstract class VarExpression extends Expression {

	protected String myVarName;
	
	public VarExpression(String name)
	{
		myVarName = name;
	}
	
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

	public boolean varMatching(String varMatcher)
	{
		return varMatcher.equals(myVarName);
	}
	
	public abstract boolean isThisVar(String varMatcher);

	
	@Override
	public abstract RGBColor evaluate(VariableData variables);

	@Override
	public String toString(){
		return " " + myVarName;
	}
}
