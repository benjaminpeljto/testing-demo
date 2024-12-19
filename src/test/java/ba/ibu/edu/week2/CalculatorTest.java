package ba.ibu.edu;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(10, 5);
        assertEquals(5, result, "10 - 5 should equal 5");
    }

    @Test
    public void testAdditionNegative() {
        Calculator calculator = new Calculator();
        assertNotEquals(6, calculator.add(2, 3), "2 + 3 should not equal 6");
    }

    @Test
    public void testArrayEquals() {
        String[] actual = { "Hello", "JUnit", "Framework" };
        String[] expected = { "Hello", "JUnit", "Framework" };

        assertArrayEquals(actual, expected);
    }

    @Test
    public void assertBooleans() {
        assertFalse(1 > 2);
        assertTrue(2 > 1);
    }

    @Test
    public void assertNullsAndNotNulls() {
        String s = null;
        assertNull(s);

        s = "Hello";
        assertNotNull(s);
    }

}