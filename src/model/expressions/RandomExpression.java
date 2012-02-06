package model.expressions;

import java.util.ArrayList;
import java.util.Random;

import model.RGBColor;

public class RandomExpression extends ParensExpression {

	
	
	public RandomExpression(ArrayList<Expression> operands) {
		super(operands, "random");
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
	
	public static ExpressionFactory getFactory()
	{
		return new ExpressionFactory(new RandomExpression(null));
	}

}
