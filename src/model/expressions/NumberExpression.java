package model.expressions;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.ParserData;
import model.RGBColor;

public class NumberExpression extends Expression {

	private static final Pattern DOUBLE_REGEX = Pattern
			.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
	private RGBColor myValue;

	public NumberExpression(double value) {
		myValue = new RGBColor(value);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> variables) {
		return myValue;
	}

	@Override
	public String toString() {
		return " " + myValue.toString();
	}

	@Override
	public boolean canParse(ParserData data) {
		return DOUBLE_REGEX.matcher(data.myInput.substring(data.myCurrentPosition)).lookingAt();
	}

	@Override
	public Expression parseExpression(ParserData data) {
		Matcher doubleMatcher = DOUBLE_REGEX.matcher(data.myInput);
		doubleMatcher.find(data.myCurrentPosition);
		String numberMatch = data.myInput.substring(doubleMatcher.start(),
				doubleMatcher.end());
		data.myCurrentPosition = doubleMatcher.end();
		double value = Double.parseDouble(numberMatch);
		return new NumberExpression(value);
	}
}
