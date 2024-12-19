package ba.ibu.edu.week4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 18, 27, 1142})
    public void testIsEven(int n) {
        NumberChecker nc = new NumberChecker();
        assertTrue(nc.isEven(n));
    }

    @ParameterizedTest
    @CsvSource({"2, 4", "3, 9", "11, 121", "15, 225"})
    public void testSquare(int n, int expected) {
        NumberChecker nc = new NumberChecker();
        assertEquals(expected, nc.square(n));
    }

    @ParameterizedTest
    @CsvSource(value={"2;4", "3;9", "11;121", "15;225"}, delimiter = ';')
    public void testSquareDelimiter(int n, int expected) {
        NumberChecker nc = new NumberChecker();
        assertEquals(expected, nc.square(n));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void testSquareCSVSource(int number, int expected){
        NumberChecker nc = new NumberChecker();
        assertEquals(expected, nc.square(number));
    }

}

