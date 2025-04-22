import org.junit.Test;
import static org.junit.Assert.*;


public class UserRegistrationTest {

    @Test
    public void testCheckUserNameCorrect() {
        UserRegistration user = new UserRegistration("usr_", "Password1!", "+27838968976");
        assertTrue(user.checkUserName());
    }

    @Test
    public void testCheckUserNameIncorrect() {
        UserRegistration user = new UserRegistration("wrongUser", "Password1!", "+27838968976");
        assertFalse(user.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexityCorrect() {
        UserRegistration user = new UserRegistration("usr_", "Password1!", "+27838968976");
        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexityIncorrect() {
        UserRegistration user = new UserRegistration("usr_", "password", "+27838968976");
        assertFalse(user.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhoneNumberCorrect() {
        UserRegistration user = new UserRegistration("usr_", "Password1!", "+27838968976");
        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testCheckCellPhoneNumberIncorrect() {
        UserRegistration user = new UserRegistration("usr_", "Password1!", "08966553");
        assertFalse(user.checkCellPhoneNumber());
    }

    @Test
    public void testRegisterUserSuccess() {
        UserRegistration user = new UserRegistration("usr_", "Password1!", "+27838968976");
        assertEquals("User successfully registered.", user.registerUser());
    }

    @Test
    public void testRegisterUserInvalidUsername() {
        UserRegistration user = new UserRegistration("user1", "Password1!", "+27838968976");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", user.registerUser());
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        UserRegistration user = new UserRegistration("usr_", "password", "+27838968976");
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", user.registerUser());
    }

    @Test
    public void testRegisterUserInvalidPhone() {
        UserRegistration user = new UserRegistration("usr_", "Password1!", "08966553");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code.", user.registerUser());
    }

    @Test
    public void testLoginSuccess() {
        UserRegistration user = new UserRegistration("usr_", "Password1!", "+27838968976");
        assertTrue(user.loginUser("usr_", "Password1!"));
    }

    @Test
    public void testLoginFail() {
        UserRegistration user = new UserRegistration("usr_", "Password1!", "+27838968976");
        assertFalse(user.loginUser("wrong_", "Password1!"));
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        UserRegistration user = new UserRegistration("usr_", "Password1!", "+27838968976");
        assertEquals("Welcome John Doe, it is great to see you again.",
                     user.returnLoginStatus("usr_", "Password1!", "John", "Doe"));
    }

    @Test
    public void testReturnLoginStatusFail() {
        UserRegistration user = new UserRegistration("usr_", "Password1!", "+27838968976");
        assertEquals("Username or password incorrect, please try again.",
                     user.returnLoginStatus("wrong_", "Password1!", "John", "Doe"));
    }
}

