package com.young.coursera.city.service;

import com.young.coursera.city.domain.model.UserInfo;
import com.young.coursera.city.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoMapper userInfoMapper;

    public UserInfoServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public int deleteById(Long id) {
        return userInfoMapper.deleteById(id);
    }

    @Override
    public int insert(UserInfo row) {
        return userInfoMapper.insert(row);
    }

    @Override
    public UserInfo findById(Long id) {
        return userInfoMapper.findById(id);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.findAll();
    }

    @Override
    public int update(UserInfo row) {
        return userInfoMapper.update(row);
    }
}
