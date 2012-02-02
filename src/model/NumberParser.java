package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.expressions.Expression;
import model.expressions.NumberExpression;

public class NumberParser extends Parser {

	// double is made up of an optional negative sign, followed by a sequence
	// of one or more digits, optionally followed by a period, then possibly
	// another sequence of digits
	private static final Pattern DOUBLE_REGEX = Pattern
			.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");

	@Override
	public Expression parseExpression(ParserData data) {
		Matcher doubleMatcher = NumberParser.DOUBLE_REGEX.matcher(data.myInput);
		doubleMatcher.find(data.myCurrentPosition);
		String numberMatch = data.myInput.substring(doubleMatcher.start(),
				doubleMatcher.end());
		data.myCurrentPosition = doubleMatcher.end();
		// this represents the color gray of the given intensity
		double value = Double.parseDouble(numberMatch);
		RGBColor gray = new RGBColor(value);
		return new NumberExpression(gray);
	}

	@Override
	public boolean isThisParser(ParserData data) {
		return DOUBLE_REGEX.matcher(data.myInput.substring(data.myCurrentPosition)).lookingAt();
	}

}
