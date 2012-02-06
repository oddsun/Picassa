package model;

import java.util.ArrayList;

import model.expressions.ATanExpression;
import model.expressions.AbsExpression;
import model.expressions.AverageExpression;
import model.expressions.CeilExpression;
import model.expressions.ClampExpression;
import model.expressions.ColorExpression;
import model.expressions.CosExpression;
import model.expressions.DivExpression;
import model.expressions.ExpExpression;
import model.expressions.Expression;
import model.expressions.FloorExpression;
import model.expressions.IfExpression;
import model.expressions.LetExpression;
import model.expressions.MaxExpression;
import model.expressions.MinExpression;
import model.expressions.MinusExpression;
import model.expressions.ModExpression;
import model.expressions.MulExpression;
import model.expressions.NegExpression;
import model.expressions.NumberExpression;
import model.expressions.PerlinBWExpression;
import model.expressions.PerlinColorExpression;
import model.expressions.PlusExpression;
import model.expressions.RGBtoYCbCrExpression;
import model.expressions.RandomExpression;
import model.expressions.SinExpression;
import model.expressions.TanExpression;
import model.expressions.VarExpression;
import model.expressions.WrapExpression;
import model.expressions.YCbCrtoRGBExpression;

public class ParserData {
	public int myCurrentPosition;
	public String myInput;
	private ArrayList<Expression> myFactoryObject;

	public ParserData(String input) {
		myInput = input;
		myCurrentPosition = 0;
		initialize();
	}
	
	private void initialize() {
		myFactoryObject = new ArrayList<Expression>();
		myFactoryObject.add(new NumberExpression(0));
		myFactoryObject.add(new VarExpression(""));
		myFactoryObject.add(new ColorExpression(null));
		myFactoryObject.add(new DivExpression(null));
		myFactoryObject.add(new ExpExpression(null));
		myFactoryObject.add(new MinusExpression(null));
		myFactoryObject.add(new ModExpression(null));
		myFactoryObject.add(new MulExpression(null));
		myFactoryObject.add(new NegExpression(null));
		myFactoryObject.add(new PlusExpression(null));
		myFactoryObject.add(new RandomExpression(null));
		myFactoryObject.add(new FloorExpression(null));
		myFactoryObject.add(new CeilExpression(null));
		myFactoryObject.add(new AbsExpression(null));
		myFactoryObject.add(new ClampExpression(null));
		myFactoryObject.add(new WrapExpression(null));
		myFactoryObject.add(new SinExpression(null));
		myFactoryObject.add(new CosExpression(null));
		myFactoryObject.add(new TanExpression(null));
		myFactoryObject.add(new ATanExpression(null));
		myFactoryObject.add(new RGBtoYCbCrExpression(null));
		myFactoryObject.add(new YCbCrtoRGBExpression(null));
		myFactoryObject.add(new PerlinColorExpression(null));
		myFactoryObject.add(new PerlinBWExpression(null));
		myFactoryObject.add(new LetExpression(null));
		myFactoryObject.add(new IfExpression(null));
		myFactoryObject.add(new AverageExpression(null));
		myFactoryObject.add(new MinExpression(null));
		myFactoryObject.add(new MaxExpression(null));
	}
	
	public void skipWhiteSpace() {
		while (notAtEndOfString() && Character.isWhitespace(currentCharacter())) {
			myCurrentPosition++;
		}
	}
	
	public char currentCharacter() {
		return myInput.charAt(myCurrentPosition);
	}

	public boolean notAtEndOfString() {
		return myCurrentPosition < myInput.length();
	}

	public Expression parseParser()
	{
		for(Expression exp: myFactoryObject)
		{
			if(exp.canParse(this))
				return exp.parseExpression(this);
		}
		skipWhiteSpace();
		int pos = myInput.indexOf(" ", myCurrentPosition);
		String commandName = pos == -1 ? "" : myInput.substring(myCurrentPosition, pos);
		throw new ParserException("Unknown Command "
		+ commandName, ParserException.Type.UNKNOWN_COMMAND);
	}
	
	public Expression makeExpression() {
		Expression result = parseParser();
		skipWhiteSpace();
		if (notAtEndOfString()) {
			throw new ParserException(
					"Unexpected characters at end of the string: "
							+ myInput.substring(myCurrentPosition),
					ParserException.Type.EXTRA_CHARACTERS);
		}
		return result;
	}
}