package model;


import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import model.expressions.Expression;



/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 */
public class Model
{
    public static final double DOMAIN_MIN = -1;
    public static final double DOMAIN_MAX = 1;
    public static final int NUM_FRAMES = 50;

    private double myCurrentTime = 0;


    /**
     * Advance to the next frame in the animation.
     */
    public void reset ()
    {
        myCurrentTime = 0;
    }


    /**
     * Advance to the next frame in the animation.
     */
    public void nextFrame ()
    {
        myCurrentTime += 1.0 / NUM_FRAMES;
    }


    /**
     * Evaluate an expression for each point in the image.
     * @param parameterObject TODO
     */
    public Pixmap evaluate (String input, Dimension size)
    {
        Pixmap result = new Pixmap(size);
        ParserData data = new ParserData(input);
        // create expression to evaluate just once
        Expression toEval = data.makeExpression();
        // evaluate at each pixel
        
        Map<String, RGBColor> myMap = new HashMap<String, RGBColor>();
        myMap.put("t", new RGBColor(myCurrentTime*2 - 1));
        for (int imageY = 0; imageY < size.height; imageY++)
        {
            myMap.put("y", new RGBColor(imageToDomainScale(imageY, size.height)));
            for (int imageX = 0; imageX < size.width; imageX++)
            {
            	myMap.put("x", new RGBColor(imageToDomainScale(imageX, size.width)));
                result.setColor(imageX, imageY, toEval.evaluate(myMap).toJavaColor());
            }
        }
        return result;
    }


    /**
     * Convert from image space to domain space.
     */
    protected double imageToDomainScale (int value, int bounds)
    {
        double range = DOMAIN_MAX - DOMAIN_MIN;
        return ((double)value / bounds) * range + DOMAIN_MIN;
    }
}
