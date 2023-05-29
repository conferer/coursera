package com.young.coursera.city.mapper;

import com.young.coursera.city.domain.model.UserInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    int deleteById(Long id);

    int insert(UserInfo row);

    UserInfo findById(Long id);

    List<UserInfo> findAll();

    int update(UserInfo row);
}