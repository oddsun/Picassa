package model.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.RGBColor;
import model.factory.ExpressionFactory;

public class LetExpression extends CmdExpression {
	
	private static final int DEFAULT_NUM_OPERANDS = 3;
//	private Map<VarExpression, Expression> varMap;

	public LetExpression(ArrayList<Expression> operands) {
		super("let", operands);
		// TODO Auto-generated constructor stub
	}

	public RGBColor evaluate(VariableData variables)
	{
		check(DEFAULT_NUM_OPERANDS, myOperands.size());
		variables.myVarMap.put((VarExpression) myOperands.get(0),myOperands.get(1).evaluate(variables));
//		System.out.println(variables.myVarMap);
		RGBColor r = myOperands.get(2).evaluate(variables);
		variables.myVarMap.remove(myOperands.get(0));
		return r;
	}
	
//	public void buildMap()
//	{
//		varMap = new HashMap<VarExpression, Expression>();
//		varMap.put((VarExpression) myOperands.get(0), myOperands.get(1));
//	}
	
	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		LetExpression exp = new LetExpression(operands);
//		exp.buildMap();
		return exp;
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new LetExpression(null));
	}

}
