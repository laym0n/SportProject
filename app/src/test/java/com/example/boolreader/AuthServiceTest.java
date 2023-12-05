package com.example.boolreader;

import com.example.boolreader.services.AuthService;

import org.junit.Assert;
import org.junit.Test;


public class AuthServiceTest {
    private AuthService SUT = AuthService.getInstance();

    @Test
    public void testAuth() {
        //Action
        SUT.auth("Victor", "pass");
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
    }

    @Test
    public void testFailedRegister() {
        //Action and Assert
        Assert.assertThrows(Exception.class, () -> SUT.register("Victor", "pass"));
    }
}
