package com.dtdhehe.ptulife.service;

import com.dtdhehe.ptulife.entity.PtuUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户service
 * crate By:dtdhehe
 * date:2018-10-29
 */
public interface UserService {

    // /添加用户
    PtuUser save(PtuUser ptuUser);

    //查找某个用户
    PtuUser findOne(String userId);

    //查找学生用户
    List<PtuUser> findStuAll();

    //查找教师用户
    List<PtuUser> findTeaAll();

    //查找职工用户
    List<PtuUser> findWorAll();

    //查找所有
    Page<PtuUser> findAll(Pageable pageable);

}
