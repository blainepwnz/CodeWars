package tests;

import codewars.kyu2.Interpreter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class ExampleInterpreterTest {

    @Test
    public void basicTests() {
        Interpreter interpreter = new Interpreter();

        // Basic arithmetic
        assertEquals( 16, interpreter.input("x = 13 + (y = 3)"), 0.0);
        assertEquals(2, interpreter.input("1 + 1"), 0.0);
        assertEquals(1, interpreter.input("2 - 1"), 0.0);
        assertEquals(6, interpreter.input("2* 3"), 0.0);
        assertEquals(2, interpreter.input("8 / 4"), 0.0);
        assertEquals(3, interpreter.input("7 % 4"), 0.0) ;
        assertEquals(2, interpreter.input("(7 + 3) / (2 * 2 + 1)"), 0.0);
        assertEquals(6, interpreter.input("(8 - (4 + 2)) * 3"), 0.0);
        assertEquals( 15, interpreter.input("(10 / (8 - (4 + 2))) * 3"), 0.0);
        assertEquals( 7, interpreter.input("x = 7"), 0.0);
        assertEquals( 7, interpreter.input("x"), 0.0);
        assertEquals( 10, interpreter.input("x + 3"), 0.0);
        assertEquals(12, interpreter.input("y = x + 5"), 0.0);
        assertEquals( 12, interpreter.input("y"), 0.0);

        // Variables
        assertEquals(1, interpreter.input("x = 1"), 0.0);
        assertEquals(1, interpreter.input("x"), 0.0);
        assertEquals(4, interpreter.input("x + 3"), 0.0);
//        assertFail("input: 'y'", () -> interpreter.input("y"));
    }

    private static void assertFail(String msg, Runnable runnable) {
        try {
            runnable.run();
            fail(msg);
        } catch (Exception e) {
            // Ok
        }
    }
}