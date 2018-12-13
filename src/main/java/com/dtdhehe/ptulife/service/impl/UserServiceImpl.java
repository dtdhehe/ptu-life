package com.dtdhehe.ptulife.service.impl;

import com.dtdhehe.ptulife.entity.PtuUser;
import com.dtdhehe.ptulife.enums.UserStatusEnum;
import com.dtdhehe.ptulife.repository.PtuUserRepository;
import com.dtdhehe.ptulife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PtuUserRepository ptuUserRepository;

    @Override
    public PtuUser save(PtuUser ptuUser) {
        return ptuUserRepository.save(ptuUser);
    }

    @Override
    public PtuUser findOne(String userId) {
        return ptuUserRepository.findById(userId).get();
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
}