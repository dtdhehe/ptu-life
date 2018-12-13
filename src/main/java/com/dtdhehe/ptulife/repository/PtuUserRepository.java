package com.dtdhehe.ptulife.repository;

import com.dtdhehe.ptulife.entity.PtuUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 用户dao
 * crate By：dtdhehe
 * date:2018-10-29
 */
public interface PtuUserRepository extends JpaRepository<PtuUser, String> {
    //添加用户
    //删除用户
    //查找用户
    //根据用户身份标识查找用户
    List<PtuUser> findByUserStatus(Integer userStatus);
    //根据性别查找用户
    List<PtuUser> findByUserSex(Integer userSex);
}
