package model.expressions;

import model.RGBColor;

/**
 * An Expression represents a mathematical expression as a tree.
 * 
 * In this format, the internal nodes represent mathematical functions and the
 * leaves represent constant values.
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, some code)
 */
public abstract class Expression {

	public Expression() {
	}

	public abstract RGBColor evaluate(double x, double y);

	public abstract String toString();
}
