package model.expressions;

import java.util.ArrayList;
import java.util.Random;

import model.RGBColor;
import model.factory.ExpressionFactory;

public class RandomExpression extends CmdExpression {

	
	
	public RandomExpression(ArrayList<Expression> operands) {
		super("random", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RGBColor calculate(ArrayList<RGBColor> operandColors) {
		Random r = new Random();
		return new RGBColor(resize(r.nextDouble()), resize(r.nextDouble()), resize(r.nextDouble()));
	}
	
	private double resize(double r)
	{
		return r * 2 - 1;
	}

	@Override
	public CmdExpression create(ArrayList<Expression> operands) {
		return new RandomExpression(operands);
	}
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new RandomExpression(null));
	}

}
