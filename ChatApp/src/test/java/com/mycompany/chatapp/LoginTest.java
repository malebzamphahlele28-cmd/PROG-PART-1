package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    
    Login login = new Login();

    // 1
    @Test
    public void testCheckUserNameCorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }
    // 2
    @Test
    public void testCheckUserNameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }
    // 3
    @Test
    public void testCheckPasswordMeetsComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&sec@ke99!"));
    }
    // 4
    @Test
    public void testCheckPasswordFailsComplexity() {
        assertFalse(login.checkPasswordComplexity("password"));
    }
    // 5
    @Test
    public void testCheckCellNumberCorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }
    // 6
    @Test
    public void testCheckCellNumberIncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
    // 7
    @Test
    public void testRegisterUserSuccessful() {
        String result = login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "Malebo", "Mphahlele");
        assertEquals("User registered successfully.", result);
    }
    // 8
    @Test
    public void testRegisterUserUsernameFailed() {
        String result = login.registerUser("kyle!!!!!!!", "Ch&sec@ke99!", "+27838968976", "Malebo", "Mphahlele");
        assertTrue(result.contains("Username is not correctly formatted"));
    }
    // 9
    @Test
    public void testRegisterUserPasswordFailed() {
        String result = login.registerUser("kyl_1", "password", "+27838968976", "Malebo", "Mphahlele");
        assertTrue(result.contains("Password is not correctly formatted"));
    }
    // 10
    @Test
    public void testLoginUserSuccessful() {
        login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "Malebo", "Mphahlele");
        assertTrue(login.loginUser("kyl_1", "Ch&sec@ke99!"));
        String status = login.returnLoginStatus("kyl_1", "Ch&sec@ke99!");
        assertTrue(status.contains("Welcome"));
    }
    // 11
    @Test
    public void testLoginUserFailedAndStatus() {
        login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "Malebo", "Mphahlele");
        assertFalse(login.loginUser("kyle!!!!!!!", "password"));
        String status = login.returnLoginStatus("kyle!!!!!!!", "password");
        assertEquals("Username or password incorrect, please try again.", status);
    }
}