package com.young.coursera.city.service;

import com.young.coursera.city.mapper.CityMapper;
import com.young.coursera.city.model.City;
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
        return cityMapper.findByState(state);
    }

    @Override
    public City create(City entity) {
        cityMapper.insert(entity);
        return entity;
    }

    @Override
    public City update(Long id, City entity) {
        cityMapper.update(entity);
        return entity;
    }

    @Override
    public City get(Long id) {
        return cityMapper.findById(id);
    }

    @Override
    public void delete(Long id) {
        cityMapper.deleteById(id);
    }

    @Override
    public List<City> list(Query query) {
        return cityMapper.findAll(query);
    }

    @Override
    public List<City> listForPage(PageQuery query) {
        return cityMapper.findAll(query);
    }

    @Override
    public City publish(Long id, Boolean flag) {
        return null;
    }
}
