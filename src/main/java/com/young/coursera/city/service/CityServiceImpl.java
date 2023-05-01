package com.young.coursera.city.service;

import com.young.coursera.city.mapper.CityMapper;
import com.young.coursera.city.domain.model.City;
import com.young.coursera.core.exception.enums.CommonError;
import com.young.coursera.core.exception.util.Asserts;
import com.young.coursera.core.lang.PageQuery;
import com.young.coursera.core.lang.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityMapper cityMapper;

    @Override
    public City findByState(String state) {
        City city = cityMapper.findByState(state);
        // 展示如何使用 Exception helper 简化异常
        Asserts.notNull(city, CommonError.NOT_FOUND);
        return city;
    }

    @Override
    public City insert(City entity) {
        cityMapper.insert(entity);
        return entity;
    }

    @Override
    public City update(Long id, City entity) {
        City existedCity = findById(id);
        cityMapper.update(entity);
        return entity;
    }

    @Override
    public City findById(Long id) {
        City city = cityMapper.findById(id);
        // 展示如何使用 Exception helper 简化异常
        Asserts.notNull(city, CommonError.NOT_FOUND);
        return city;
    }

    @Override
    public void delete(Long id) {
        cityMapper.deleteById(id);
    }

    @Override
    public List<City> findAll(Query query) {
        return cityMapper.findAll(query);
    }

    @Override
    public List<City> findPage(PageQuery query) {
        return cityMapper.findAll(query);
    }

    @Override
    public City publish(Long id, Boolean flag) {
        return null;
    }
}
