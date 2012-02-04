package tests;

import java.awt.Color;
import model.Parser;
import model.ParserException;
import model.ParserMediator;
import model.RGBColor;
import model.expressions.VariableData;
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
        RGBColor actual = ParserMediator.makeExpression("1").evaluate(new VariableData(0, 0));
        assertTrue(WHITE.equals(actual));
        actual = ParserMediator.makeExpression("-1").evaluate(new VariableData(0, 0));
        assertTrue(BLACK.equals(actual));
        actual = ParserMediator.makeExpression("0.5").evaluate(new VariableData(0, 0));
        assertTrue(GRAY.equals(actual));
        actual = ParserMediator.makeExpression(".5").evaluate(new VariableData(0, 0));
        assertTrue(GRAY.equals(actual));
        try
        {
            ParserMediator.makeExpression("0.5 0.5").evaluate(new VariableData(0, 0));
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
        RGBColor actual = ParserMediator.makeExpression("(plus .1 .9)").evaluate(new VariableData(0, 0));
        assertTrue(WHITE.equals(actual));
        actual = ParserMediator.makeExpression("(plus (plus 0.01 0.09) (plus 0.4 0.5))").evaluate(new VariableData(0, 0));
        assertTrue(WHITE.equals(actual));
        actual = ParserMediator.makeExpression("    (plus(plus 0.01 0.09)(plus 0.4 0.5   ))    ").evaluate(new VariableData(0, 0));
        assertTrue(WHITE.equals(actual));
        actual = ParserMediator.makeExpression("(minus (div 1.8 2) (mul -10 0.01))").evaluate(new VariableData(0, 0));
        assertTrue(WHITE.equals(actual));
        try
        {
            ParserMediator.makeExpression("(fooo 0.1 0.9)").evaluate(new VariableData(0, 0));
            fail("Exception should have been thrown");
        }
        catch (ParserException e)
        {
            // actually that's good
            assertEquals(ParserException.Type.UNKNOWN_COMMAND, e.getType());
        }
    }
}
