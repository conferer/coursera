package com.young.coursera.city.service;

import com.young.coursera.city.domain.model.City;
import com.young.coursera.core.persist.service.BaseService;

public interface CityService extends BaseService<City>{

    City findByState(String state);
}
