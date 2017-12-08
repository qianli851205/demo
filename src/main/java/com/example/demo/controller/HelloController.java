package com.example.demo.controller;

import com.example.demo.properties.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/hello")
public class HelloController {
    @Value("${filepath}")
    private String filepath;
    @Value("${content}")
    private String content;

   @Autowired
   private PersonProperties person;

    @RequestMapping(value={"/say","/index"},method = RequestMethod.POST)
    public String say(){
       // return "哈哈,  "+content;
        return person.getName()+"-"+ person.getAge()+"-"+ person.getPhone()
                +"-"+ person.getAddress();
    }

    /**
     * 网页地址栏输入信息：http://localhost:8081/hello/testPathvariable/34
     * @param id
     * @return id=34
     */
    //@RequestMapping(value="/testPathvariable/{id}",method=RequestMethod.GET)
    @GetMapping(value="/testPathvariable/{id}")
    public String testPathvariable(@PathVariable("id") Integer id){
        return "id="+id;
    }

    /**
     * 网页地址栏输入：http://localhost:8081/hello/testRequestparam?id=456
     * @param myId 不需要必须传值，默认id=999
     * @return  id=456
     */
    @RequestMapping(value="/testRequestparam",method=RequestMethod.GET)
    public String testRequestparam(@RequestParam(value="id",required =false,defaultValue ="999") Integer myId){
        return "id="+myId;
    }

}
