package model.expressions;

import java.util.ArrayList;
import java.util.Map;

import model.ParserException;
import model.RGBColor;

public class LetExpression extends ParensExpression {
	
	private static final int DEFAULT_NUM_OPERANDS = 3;
	private static final String[] FORBIDDEN_NAMES = {"x", "y", "t"};
//	private Map<VarExpression, Expression> varMap;

	public LetExpression(ArrayList<Expression> operands) {
		super(operands, "let");
		// TODO Auto-generated constructor stub
	}

	public RGBColor evaluate(Map<String, RGBColor> variableMap)
	{
		check(DEFAULT_NUM_OPERANDS, myOperands.size());
		String varName = ((VarExpression) myOperands.get(0)).getMyVarName();
		for(String s : FORBIDDEN_NAMES)
			if (s.equals(varName))
				throw new ParserException("Too bad, I, " + varName + ", am already taken!!");
		variableMap.put(varName, myOperands.get(1).evaluate(variableMap));
		RGBColor r = myOperands.get(2).evaluate(variableMap);
		variableMap.remove(myOperands.get(0));
		return r;
	}
	
	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParensExpression create(ArrayList<Expression> operands) {
		return new LetExpression(operands);
	}

}
