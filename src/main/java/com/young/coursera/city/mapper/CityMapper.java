package com.young.coursera.city.mapper;

import com.young.coursera.city.domain.model.City;

import java.util.List;

import com.young.coursera.core.lang.Query;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {
    int deleteById(Long id);

    int insert(City row);

    City findById(Long id);

    List<City> findAll(Query query);

    int update(City row);

    @Select("select * from `city` where state = ?")
    City findByState(@Param("state") String state);
}