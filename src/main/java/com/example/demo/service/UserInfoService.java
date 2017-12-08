package com.example.demo.service;

import com.example.demo.entity.Userinfo;

public interface UserInfoService {
     //根据id查找人员
     Userinfo findOne(Integer id);
     //根据年龄判断上的学校
     void getAge(Integer id) throws Exception;
}
