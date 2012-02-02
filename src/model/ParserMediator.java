package model;

import java.util.ArrayList;

import model.expressions.Expression;

public class ParserMediator {
	
	private static ArrayList<Parser> myParsers;
	
	static
	{
		myParsers = new ArrayList<Parser>();
		myParsers.add(new NumberParser());
		myParsers.add(new VariableParser());
		myParsers.add(new ParensParser());
	}
	
	public static Expression parseParser(ParserData data)
	{
		for(Parser parser : myParsers)
		{
			if(parser.isThisParser(data))
				return parser.parseExpression(data);
		}
		throw new ParserException("Unknown Parser!");
	}
	
	public static Expression makeExpression(String input) {
		ParserData data = new ParserData (input, 0);
		Expression result = parseParser(data);
		Parser.skipWhiteSpace(data);
		if (Parser.notAtEndOfString(data)) {
			throw new ParserException(
					"Unexpected characters at end of the string: "
							+ data.myInput.substring(data.myCurrentPosition),
					ParserException.Type.EXTRA_CHARACTERS);
		}
		return result;
	}
}
