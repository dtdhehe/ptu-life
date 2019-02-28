package com.dtdhehe.ptulife.service.impl;

import com.dtdhehe.ptulife.entity.PtuUser;
import com.dtdhehe.ptulife.enums.UserStatusEnum;
import com.dtdhehe.ptulife.repository.PtuUserRepository;
import com.dtdhehe.ptulife.service.UserService;
import com.dtdhehe.ptulife.util.CheckUserUtils;
import com.dtdhehe.ptulife.util.KeyUtils;
import com.dtdhehe.ptulife.vo.UserRegistVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PtuUserRepository ptuUserRepository;

    @Override
    public PtuUser save(UserRegistVO userRegistVO) {
        PtuUser ptuUser = new PtuUser();
        BeanUtils.copyProperties(userRegistVO,ptuUser);
        ptuUser.setUserId(KeyUtils.getUniqueKey());
        ptuUser.setUserSex(CheckUserUtils.checkSex(userRegistVO.getUserSex()));
        ptuUser.setUserStatus(CheckUserUtils.checkStatus(userRegistVO.getUserStatus()));
        String motto = ptuUser.getMotto();
        if (StringUtils.isEmpty(motto)){
            ptuUser.setMotto("这个人很懒,什么都没有留下～");
        }
        return ptuUserRepository.save(ptuUser);
    }

    @Override
    public PtuUser findOne(HttpServletRequest request) {
        PtuUser ptuUser = (PtuUser) request.getSession().getAttribute("loginUser");
        return ptuUserRepository.findById(ptuUser.getUserId()).get();
    }

    @Override
    public List<PtuUser> findStuAll() {
        return ptuUserRepository.findByUserStatus(UserStatusEnum.Stu.getCode());
    }

    @Override
    public List<PtuUser> findTeaAll() {
        return ptuUserRepository.findByUserStatus(UserStatusEnum.Tea.getCode());
    }

    @Override
    public List<PtuUser> findWorAll() {
        return ptuUserRepository.findByUserStatus(UserStatusEnum.Wor.getCode());
    }

    @Override
    public Page<PtuUser> findAll(Pageable pageable) {
        return ptuUserRepository.findAll(pageable);
    }

    @Override
    public PtuUser findByUserNameAndUserPwd(String userName, String userPwd) {
        return ptuUserRepository.findByUserNameAndUserPwd(userName,userPwd);
    }

    @Override
    public String getUserNameByUserId(String userId) {
        PtuUser ptuUser = ptuUserRepository.findById(userId).get();
        return ptuUser.getNickName();
    }

    @Override
    public PtuUser update(PtuUser ptuUser) {
        //springdatajpa使用save来更新，若不存在id，则是新增
        return ptuUserRepository.save(ptuUser);
    }
}
