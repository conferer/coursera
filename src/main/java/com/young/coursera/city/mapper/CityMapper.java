package com.young.coursera.city.mapper;

import com.young.coursera.city.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityMapper {

    @Select("select id, name, state, country from city where state = #{state}")
    City findByState(@Param("state") String state);

    @Select("select * from city")
    List<City> selectAll();

    @Select("select * from city")
    List<City> selectForPage(@Param("page") int page, @Param("pageSize") int pageSize);

    int insert(City city);
}
