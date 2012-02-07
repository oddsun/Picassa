package model;


import java.awt.Dimension;
import java.util.ArrayList;
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
        
        Map<String, ArrayList<RGBColor>> myMap = new HashMap<String, ArrayList<RGBColor>>();
        ArrayList<RGBColor> t = new ArrayList<RGBColor>();
        t.add(new RGBColor(myCurrentTime*2 - 1));
        ArrayList<RGBColor> x = new ArrayList<RGBColor>();
        x.add(new RGBColor(0));
        ArrayList<RGBColor> y = new ArrayList<RGBColor>();
        y.add(new RGBColor(0));
        myMap.put("t", t);
        myMap.put("y", y);
        myMap.put("x", x);
        for (int imageY = 0; imageY < size.height; imageY++)
        {
            y.set(0, new RGBColor(imageToDomainScale(imageY, size.height)));
            for (int imageX = 0; imageX < size.width; imageX++)
            {
                x.set(0 , new RGBColor(imageToDomainScale(imageX, size.width)));
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
