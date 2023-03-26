package com.young.coursera.city.service;

import com.young.coursera.city.model.City;
import com.young.coursera.core.lang.PageQuery;
import com.young.coursera.core.lang.Query;
import com.young.coursera.core.persist.service.BaseService;

public interface CityService extends BaseService<City>{

    City findByState(String state);
}
