package ba.ibu.edu.week5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testCheckToken_WithValidToken_ShouldReturnTrue() {
        // Test with the correct token
        assertTrue(userManager.checkToken("GfkLXyk4EJef8NGZ"));
    }

    @Test
    public void testCheckToken_WithInvalidToken_ShouldReturnFalse() {
        // Test with an incorrect token
        assertFalse(userManager.checkToken("invalidToken"));
    }
}