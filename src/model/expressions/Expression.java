package model.expressions;

import java.util.ArrayList;
import java.util.Map;

import model.*;

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

	public abstract boolean canParse(ParserData data);
	
	public abstract Expression parseExpression(ParserData data);
	
	public abstract RGBColor evaluate(Map<String, ArrayList<RGBColor>> variables);

	public abstract String toString();
}
