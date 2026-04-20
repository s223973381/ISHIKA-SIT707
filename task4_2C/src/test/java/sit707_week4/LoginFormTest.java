package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ishika Mandal
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "s223973381";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Ishika Mandal";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Username", status.getErrorMsg());
	}
	
	@Test
	public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login(null, "xyz");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Username", status.getErrorMsg());
	}
	
	@Test
	public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login(null, "ishika_pass");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Username", status.getErrorMsg());
	}
	
	@Test
	public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("abc", null);
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Password", status.getErrorMsg());
	}
	
	@Test
	public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("abc", "xyz");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}
	
	@Test
	public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("abc", "ishika_pass");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}
	
	@Test
	public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("ishika", null);
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Password", status.getErrorMsg());
	}
	
	@Test
	public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("ishika", "xyz");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}
	
	@Test
	public void testFailCorrectUsernameAndCorrectPasswordAndEmptyValidationCode() {
		LoginStatus status = LoginForm.login("ishika", "ishika_pass");
		Assert.assertTrue(status.isLoginSuccess());
		Assert.assertEquals("123456", status.getErrorMsg());
		
		boolean isValid = LoginForm.validateCode(null);
		Assert.assertFalse(isValid);
	}
	
	@Test
	public void testFailCorrectUsernameAndCorrectPasswordAndWrongValidationCode() {
		LoginStatus status = LoginForm.login("ishika", "ishika_pass");
		Assert.assertTrue(status.isLoginSuccess());
		Assert.assertEquals("123456", status.getErrorMsg());
		
		boolean isValid = LoginForm.validateCode("abcd");
		Assert.assertFalse(isValid);
	}
	
	@Test
	public void testPassCorrectUsernameAndCorrectPasswordAndCorrectValidationCode() {
		LoginStatus status = LoginForm.login("ishika", "ishika_pass");
		Assert.assertTrue(status.isLoginSuccess());
		Assert.assertEquals("123456", status.getErrorMsg());
		
		boolean isValid = LoginForm.validateCode("123456");
		Assert.assertTrue(isValid);
	}
	
	/*
	 * Write more test functions below.
	 */
}
