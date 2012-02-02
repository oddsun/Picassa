package model.util;

import model.RGBColor;
import model.expressions.TwoOperandSymmetricCmdExpression;


/**
 * Combine two colors by combining their components.
 * 
 * This is a separate class from color since it is just one set of
 * ways to combine colors, many may exist and we do not want to keep
 * modifying the RGBColor class.
 * 
 * @author Robert C. Duvall
 */
public class ColorComputation
{
    
    
//    public static RGBColor color (RGBColor one, RGBColor two, RGBColor three)
//    {
//    	return new RGBColor(one.getRed(), two.getGreen(), three.getBlue());
//    }

    public static RGBColor neg (RGBColor exp)
    {
    	return new RGBColor(-exp.getRed(),-exp.getGreen(),-exp.getBlue());
    }
}
