package model;

import model.expressions.*;


/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * Due to the nature of the language being parsed, a recursive descent parser is
 * used http://en.wikipedia.org/wiki/Recursive_descent_parser
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions, some functions)
 */
public abstract class Parser {
	
	

	/**
	 * Converts given string into expression tree.
	 * 
	 * @param input
	 *            expression given in the language to be parsed
	 * @return expression tree representing the given formula
	 */
	public abstract Expression parseExpression(ParserData data);

	public static void skipWhiteSpace(ParserData data) {
		while (notAtEndOfString(data) && Character.isWhitespace(currentCharacter(data))) {
			data.myCurrentPosition++;
		}
	}

	public static char currentCharacter(ParserData data) {
		return data.myInput.charAt(data.myCurrentPosition);
	}

	public static boolean notAtEndOfString(ParserData data) {
		return data.myCurrentPosition < data.myInput.length();
	}

	public abstract boolean isThisParser(ParserData data);
}
