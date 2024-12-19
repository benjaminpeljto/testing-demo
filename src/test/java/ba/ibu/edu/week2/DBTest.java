package ba.ibu.edu;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DBTest {

    private static DB database;

    @BeforeAll
    public static void setUpBeforeClass() {
        database = new DB();
        database.connect();
    }

    @BeforeEach
    public void setUp() {
        database.insert("Element 1");
        database.insert("Element 2");
    }

    @Order(1)
    @Test
    public void testGetMethod() {
        assertEquals(database.get(1), "Element 2");
    }

    @Order(2)
    @Test
    public void testInsert() {
        database.insert("Element 3");
        assertEquals(3, database.count());
        assertEquals(database.get(2), "Element 3");
    }

    @Test
    public void testGetOutOfBounds() {
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {
            String element = database.get(10);
        });

        assertEquals("Index 10 out of bounds for length 2", e.getMessage());
    }

    @AfterEach
    public void tearDown() {
        database.clear();
    }

    @AfterAll
    public static void tearDownAfterClass() {
        database.disconnect();
    }
}
