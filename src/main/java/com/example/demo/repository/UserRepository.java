package com.example.demo.repository;

import com.example.demo.entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *  extends JpaRepository<类名,id类型>
 */
public interface UserRepository extends JpaRepository<Userinfo,Integer> {
    //通过年龄查询
    List<Userinfo> findByUserage(Integer age);
}
