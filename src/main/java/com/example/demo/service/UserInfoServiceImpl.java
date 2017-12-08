package com.example.demo.service;

import com.example.demo.entity.Userinfo;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.ResultEnum;
import com.example.demo.utils.ResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public Userinfo findOne(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public void getAge(Integer id) throws Exception {
        Userinfo user=userRepository.findOne(id);
        Integer age=user.getUserage();
        if(age<10){
            throw new ResultException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 && age<16){
            throw  new ResultException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
