package model.expressions;

import model.RGBColor;

public class NumberExpression extends Expression {

	private RGBColor myValue;

	public NumberExpression(RGBColor value) {
		myValue = value;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return myValue;
	}

	@Override
	public String toString() {
		return " " + myValue.toString();
	}
}
