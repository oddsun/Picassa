package model.expressions;

import java.util.Map;

import model.ParserException;
import model.RGBColor;

public class GeneralVarExpression extends VarExpression {

	public GeneralVarExpression(String name) {
		super(name);
	}

	@Override
	public boolean isThisVar(String varMatcher) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public RGBColor evaluate(VariableData variables) {
		Map<VarExpression, RGBColor> map = variables.myVarMap;
//		System.out.println(variables.myVarMap);
		if (map.size() > 0) {
			for (VarExpression key : map.keySet()) {
//				System.out.println(varMatching(key.myVarName));
				if (varMatching(key.myVarName))
					return map.get(key);
			}
		}
		throw new ParserException("no value assigned to this variable "
				+ myVarName);

	}

	// @Override
	// public String toString() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
