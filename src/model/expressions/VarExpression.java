package model.expressions;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.ParserData;
import model.RGBColor;

public class VarExpression extends Expression {

	private String myVarName;
	private static final Pattern VAR_REGEX = Pattern.compile("[a-zA-Z]+");
	
	public VarExpression(String varMatcher)
	{
		myVarName = varMatcher;
	}
	
	public Expression parseExpression(ParserData data) {
		Matcher xyMatcher = VarExpression.VAR_REGEX.matcher(data.myInput);
		xyMatcher.find(data.myCurrentPosition);
		String varMatcher = data.myInput.substring(xyMatcher.start(), xyMatcher.end());
		data.myCurrentPosition = xyMatcher.end();
		return new VarExpression(varMatcher);
	}

	@Override
	public boolean canParse(ParserData data) {
		return VarExpression.VAR_REGEX.matcher(data.myInput.substring(data.myCurrentPosition)).lookingAt();
	}

	public RGBColor evaluate(Map<String, ArrayList<RGBColor>> variables)
	{
		ArrayList<RGBColor> colors = variables.get(getMyVarName());
		return colors.get(colors.size()-1);
	}
	
	@Override
	public String toString(){
		return " " + getMyVarName();
	}

	public String getMyVarName() {
		return myVarName;
	}
}
