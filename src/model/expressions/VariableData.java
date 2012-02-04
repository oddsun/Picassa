package model.expressions;

import java.util.HashMap;
import java.util.Map;

import model.RGBColor;

public class VariableData {
	public double x;
	public double y;
	public Map<VarExpression, RGBColor> myVarMap;

	public VariableData(double x, double y) {
		this.x = x;
		this.y = y;
		myVarMap = new HashMap<VarExpression, RGBColor>();
	}
}