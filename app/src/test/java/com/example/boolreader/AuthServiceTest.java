package com.example.boolreader;

import com.example.boolreader.domain.User;
import com.example.boolreader.services.AuthService;

import org.junit.Assert;
import org.junit.Test;


public class AuthServiceTest {
    private AuthService SUT = AuthService.getInstance();

    @Test
    public void testAuth() {
        //Action
        SUT.auth("Victor", "pass");

        //Assert
        User currentUser = SUT.getCurrentUser();
        Assert.assertEquals("Victor", currentUser.getLogin());
    }

    @Test
    public void testFailedAuth() {
        //Action and Assert
        Assert.assertThrows(Exception.class, () -> SUT.auth("Victor", "pass1"));
    }
    @Test
    public void testRegister() {
        //Action
        SUT.register("Victor1", "pass");

        //Assert
        SUT.auth("Victor1", "pass");
        User currentUser = SUT.getCurrentUser();
        Assert.assertEquals("Victor1", currentUser.getLogin());
    }

    @Test
    public void testFailedRegister() {
        //Action and Assert
        Assert.assertThrows(Exception.class, () -> SUT.register("Victor", "pass"));
    }
}
