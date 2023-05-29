package com.young.coursera.service;

import com.young.coursera.CourseraApplicationTests;
import com.young.coursera.city.domain.model.UserInfo;
import com.young.coursera.city.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTest extends CourseraApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(22L);
        userInfo.setAge(22);
        userInfo.setName("allen");
        userInfo.setSex("男");
        userInfoService.insert(userInfo);
    }
}
