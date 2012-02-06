package tests;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import model.ParserException;
import model.ParserMediator;
import model.RGBColor;
import static org.junit.Assert.*;
import org.junit.*;


public class ParserTest
{
    // useful constants
    private static final RGBColor BLACK = new RGBColor(Color.BLACK);
    private static final RGBColor GRAY = new RGBColor(0.5);
    private static final RGBColor WHITE = new RGBColor(Color.WHITE);

    
//    private Parser myParser = new Parser();


    @Before
    public void setUp ()
    {
        // initialize stuff here
    }


    @Test
    public void testConstant ()
    {
    	ParserMediator med = new ParserMediator();
    	Map<String, RGBColor> myMap = new HashMap<String, RGBColor>();
        RGBColor actual = med.makeExpression("1").evaluate(myMap);
        assertTrue(WHITE.equals(actual));
        actual = med.makeExpression("-1").evaluate(myMap);
        assertTrue(BLACK.equals(actual));
        actual = med.makeExpression("0.5").evaluate(myMap);
        assertTrue(GRAY.equals(actual));
        actual = med.makeExpression(".5").evaluate(myMap);
        assertTrue(GRAY.equals(actual));
        try
        {
            med.makeExpression("0.5 0.5").evaluate(myMap);
            fail("Exception should have been thrown");
        }
        catch (ParserException e)
        {
            // actually that's good
            assertEquals(ParserException.Type.EXTRA_CHARACTERS, e.getType());
        }
        assertTrue(GRAY.equals(actual));
    }


    @Test
    public void testBinaryOps ()
    {
    	ParserMediator med = new ParserMediator();
    	Map<String, RGBColor> myMap = new HashMap<String, RGBColor>();
        RGBColor actual = med.makeExpression("(plus .1 .9)").evaluate(myMap);
        assertTrue(WHITE.equals(actual));
        actual = med.makeExpression("(plus (plus 0.01 0.09) (plus 0.4 0.5))").evaluate(myMap);
        assertTrue(WHITE.equals(actual));
        actual = med.makeExpression("    (plus(plus 0.01 0.09)(plus 0.4 0.5   ))    ").evaluate(myMap);
        assertTrue(WHITE.equals(actual));
        actual = med.makeExpression("(minus (div 1.8 2) (mul -10 0.01))").evaluate(myMap);
        assertTrue(WHITE.equals(actual));
        try
        {
            med.makeExpression("(fooo 0.1 0.9)").evaluate(myMap);
            fail("Exception should have been thrown");
        }
        catch (ParserException e)
        {
            // actually that's good
            assertEquals(ParserException.Type.UNKNOWN_COMMAND, e.getType());
        }
    }
}
