package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.expressions.*;

public class VariableParser extends Parser {

	private static final Pattern VAR_REGEX = Pattern.compile("[a-zA-Z]+");
	
	private ArrayList<VarExpression> myVars;
	
	public VariableParser(){
		initialize();
	}
	
	public void initialize() {
		myVars = new ArrayList<VarExpression>();
		myVars.add(new XVarExpression());
		myVars.add(new YVarExpression());
//		myVars.add(new GeneralVarExpression(""));
	}

	@Override
	public Expression parseExpression(ParserData data) {
			Matcher xyMatcher = VAR_REGEX.matcher(data.myInput);
			xyMatcher.find(data.myCurrentPosition);
			String varMatcher = data.myInput.substring(xyMatcher.start(), xyMatcher.end());
			data.myCurrentPosition = xyMatcher.end();
//			System.out.println(data.isLet);
			if(data.isLet) return new GeneralVarExpression(varMatcher);
			for(VarExpression var : myVars)
			{
				if(var.isThisVar(varMatcher))
					return var;
			}
//			System.out.println(data.myCurrentPosition);
			throw new ParserException("Unknown Variable "
					+ varMatcher);
		}
	
	@Override
	public boolean isThisParser(ParserData data) {
		return VAR_REGEX.matcher(data.myInput.substring(data.myCurrentPosition)).lookingAt();
	}


}
