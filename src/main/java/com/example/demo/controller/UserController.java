package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.Userinfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoService userInfoService;

    private final static Logger logger =LoggerFactory.getLogger(UserController.class);

    /**
     * 查询人员列表
     * @return
     */
    @GetMapping(value="/userinfos")
    public List<Userinfo> userinfoList(){
        return userRepository.findAll();
    }

    /**
     * 添加人员
     * @return
     */
    @PostMapping(value="/userinfos")
    public Result<Userinfo> userinfoAdd(@Valid Userinfo user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            /*Result result=new Result();
            result.setCode(-1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            result.setCode(null);
            return result;*/
            return ResultUtil.error(-1,bindingResult.getFieldError().getDefaultMessage());
        }
        /*Result result=new Result();
        result.setCode(1);
        result.setMsg("添加成功");
        result.setData(userRepository.save(user));
        return result;*/
        return ResultUtil.success(userRepository.save(user));
    }
    /**
     * 查询根据id
     */
    @GetMapping(value="/userinfos/{id}")
    public Userinfo userfindone(@PathVariable("id") Integer myId){

        return userInfoService.findOne(myId);
    }
    /**
     * 更新根据id
     */
    @PutMapping(value="/userinfos/{id}")
    public Userinfo updategirls(@PathVariable("id") Integer myId, Userinfo user){
        user.setUserid(myId);
        return userRepository.save(user);
    }

    /**
     * 删除根据id
     */
    @DeleteMapping(value="/userinfos/{id}")
    public void deleteUserinfo(@PathVariable("id") Integer myId){
        userRepository.delete(myId);
    }
    /**
     * 查询根据age
     */
    @GetMapping(value="/userinfos/age/{age}")
    public List<Userinfo> userfindByage(@PathVariable("age") Integer myage){
        return userRepository.findByUserage(myage);
    }

    /**
     * 根据年龄判断在上小学还是初中
     */
   @GetMapping(value="/userinfos/myage/{id}")
    public void getAge(@PathVariable("id")Integer id) throws  Exception{
       userInfoService.getAge(id);
   }
}
