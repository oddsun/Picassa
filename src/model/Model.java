package model;


import java.awt.Dimension;

import model.expressions.Expression;
import model.expressions.VariableData;



/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 */
public class Model
{
    public static final double DOMAIN_MIN = -1;
    public static final double DOMAIN_MAX = 1;


    /**
     * Evaluate an expression for each point in the image.
     * @param parameterObject TODO
     */
    public Pixmap evaluate (String input, Dimension size)
    {
        Pixmap result = new Pixmap(size);
        // create expression to evaluate just once
        Expression toEval = ParserMediator.makeExpression(input);
        // evaluate at each pixel
        
        VariableData var = new VariableData(0,0);
        for (int imageY = 0; imageY < size.height; imageY++)
        {
            var.y = imageToDomainScale(imageY, size.height);
            for (int imageX = 0; imageX < size.width; imageX++)
            {
                var.x = imageToDomainScale(imageX, size.width);
                result.setColor(imageX, imageY,
                                toEval.evaluate(var).toJavaColor());
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
