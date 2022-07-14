package loginTest;

import static org.junit.jupiter.api.Assertions.*;

import loginMenu.LoginMenu;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class LoginTest {

    static LoginMenu loginBox = new LoginMenu();
    static String userName;
    static String pwd;
    static String email;

    @BeforeAll
    static void setUp(){
        loginBox = new LoginMenu();
        userName = "alialvi";
        pwd = "seg3101";
        email = "ali.alvi@gmail.com";
    }

    @Test
    void checkLogin(){
        //Checks if Login works
        assertTrue(loginBox.login(userName,pwd));
        assertFalse(loginBox.login("wrongUser","wrongPwd"));
        assertFalse(loginBox.login(userName,"wrongPwd"));
    }

    @Test
    void changePassword(){
        //Change password
        assertEquals("INVALID LENGTH",loginBox.changePassword(userName,"ali"));
        assertEquals("INVALID LENGTH",loginBox.changePassword(userName,"aliAA"));
        assertEquals("SUCCESS",loginBox.changePassword(userName,"aliIsCool"));
        pwd = "aliIsCool";
        checkLogin();
        assertEquals("WRONG USERNAME",loginBox.changePassword("wrongUser","aliIsNice"));
    }

    @Test
    void changeUserName(){
        //Change userName
        assertEquals("INVALID LENGTH",loginBox.changeUsername(email,"ali"));
        assertEquals("INVALID LENGTH",loginBox.changeUsername(email,"aliA"));
        assertEquals("SUCCESS",loginBox.changeUsername(email,"ali2000Cool"));
        userName = "ali2000Cool";
        assertEquals("WRONG EMAIL",loginBox.changeUsername("wrongEmail","ali2000Cool"));
        checkLogin();
        changePassword();
        checkLogin();
    }
}
