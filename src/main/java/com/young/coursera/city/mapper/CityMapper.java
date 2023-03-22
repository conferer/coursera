package com.young.coursera.city.mapper;

import com.young.coursera.city.model.City;
import java.util.List;

public interface CityMapper {
    int deleteById(Long id);

    int insert(City row);

    City selectById(Long id);

    List<City> selectAll();

    int update(City row);
}