package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginUnitTest {

    @Test
    public void testValidLogin() {
        assertTrue(LoginService.login("Ishika", "Ishika_M", "2001-10-03"));
    }

    @Test
    public void testWrongUsername() {
        assertFalse(LoginService.login("wrong", "Ishika_M", "2001-10-03"));
    }

    @Test
    public void testWrongPassword() {
        assertFalse(LoginService.login("Ishika", "wrongpass", "2001-10-03"));
    }

    @Test
    public void testWrongDob() {
        assertFalse(LoginService.login("Ishika", "Ishika_M", "2000-12-12"));
    }

    @Test
    public void testNullUsername() {
        assertFalse(LoginService.login(null, "Ishika_M", "2001-10-03"));
    }

    @Test
    public void testNullPassword() {
        assertFalse(LoginService.login("Ishika", null, "2001-10-03"));
    }

    @Test
    public void testNullDob() {
        assertFalse(LoginService.login("Ishika", "Ishika_M", null));
    }

    @Test
    public void testEmptyUsername() {
        assertFalse(LoginService.login("", "Ishika_M", "2001-10-03"));
    }

    @Test
    public void testEmptyPassword() {
        assertFalse(LoginService.login("Ishika", "", "2001-10-03"));
    }

    @Test
    public void testEmptyDob() {
        assertFalse(LoginService.login("Ishika", "Ishika_M", ""));
    }

    @Test
    public void testInvalidDobFormat() {
        assertFalse(LoginService.login("Ishika", "Ishika_M", "03-10-2001"));
    }
}