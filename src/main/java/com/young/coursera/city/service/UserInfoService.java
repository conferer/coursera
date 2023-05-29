package com.young.coursera.city.service;

import com.young.coursera.city.domain.model.UserInfo;

import java.util.List;

public interface UserInfoService {
    int deleteById(Long id);

    int insert(UserInfo row);

    UserInfo findById(Long id);

    List<UserInfo> findAll();

    int update(UserInfo row);
}
