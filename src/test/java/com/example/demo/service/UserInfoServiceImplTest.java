package com.example.demo.service;

import com.example.demo.entity.Userinfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceImplTest {
    @Autowired
    private UserInfoService userInfoService;
    @Test
    public void findOne() throws Exception {
        Userinfo user=userInfoService.findOne(6);
        Assert.assertEquals(new Integer(30),user.getUserage());
    }

}