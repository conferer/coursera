package com.young.coursera.city.mapper;

import com.young.coursera.city.model.City;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {
    int deleteById(Long id);

    int insert(City row);

    City selectById(Long id);

    List<City> selectAll();

    List<City> selectAll(Integer page, Integer pageSize);

    int update(City row);

    @Select("select * from `city` where state = ?")
    City findByState(@Param("state") String state);
}