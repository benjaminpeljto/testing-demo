package ba.ibu.edu.week4;

import ba.ibu.edu.week4.converters.PointConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @ParameterizedTest
    @CsvSource({"0,3,4,0,5"})
    void testDistance(int x1, int yl, int x2, int y2, double distance) {
        Point p1 = new Point(x1, yl);
        Point p2 = new Point(x2, y2);
        assertEquals(5, p1.distance(p2));
        assertEquals(5, p2.distance(p1));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,3;4,0;5"}, delimiter = ';')
    void testDistanceArgConverter(
            @ConvertWith(PointConverter.class) Point p1,
            @ConvertWith(PointConverter.class) Point p2,
            double distance
    ) {
        assertEquals(5, p1.distance(p2));
        assertEquals(5, p2.distance(p1));
    }



}