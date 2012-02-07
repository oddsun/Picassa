package tests;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import model.ParserException;
import model.ParserData;
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
    	ParserData data = new ParserData("1");
    	Map<String, RGBColor> myMap = new HashMap<String, RGBColor>();
        RGBColor actual = data.makeExpression().evaluate(myMap);
        assertTrue(WHITE.equals(actual));
    	data = new ParserData("-1");
        actual = data.makeExpression().evaluate(myMap);
        assertTrue(BLACK.equals(actual));
    	data = new ParserData("0.5");
        actual = data.makeExpression().evaluate(myMap);
        assertTrue(GRAY.equals(actual));
    	data = new ParserData(".5");
        actual = data.makeExpression().evaluate(myMap);
        assertTrue(GRAY.equals(actual));
        try
        {
        	data = new ParserData("0.5 0.5");
        	data.makeExpression().evaluate(myMap);
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
    	ParserData data = new ParserData("(plus .1 .9)");
    	Map<String, RGBColor> myMap = new HashMap<String, RGBColor>();
        RGBColor actual = data.makeExpression().evaluate(myMap);
        assertTrue(WHITE.equals(actual));
    	data = new ParserData("(plus (plus 0.01 0.09) (plus 0.4 0.5))");
        actual = data.makeExpression().evaluate(myMap);
        assertTrue(WHITE.equals(actual));
    	data = new ParserData("    (plus(plus 0.01 0.09)(plus 0.4 0.5   ))    ");
        actual = data.makeExpression().evaluate(myMap);
        assertTrue(WHITE.equals(actual));
    	data = new ParserData("(minus (div 1.8 2) (mul -10 0.01))");
        actual = data.makeExpression().evaluate(myMap);
        assertTrue(WHITE.equals(actual));
        try
        {
        	data = new ParserData("(fooo 0.1 0.9)");
        	data.makeExpression().evaluate(myMap);
            fail("Exception should have been thrown");
        }
        catch (ParserException e)
        {
            // actually that's good
            assertEquals(ParserException.Type.UNKNOWN_COMMAND, e.getType());
        }
    }
}
