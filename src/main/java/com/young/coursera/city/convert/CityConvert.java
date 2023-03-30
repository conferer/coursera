package com.young.coursera.city.convert;

import com.young.coursera.city.domain.dto.CityDto;
import com.young.coursera.city.domain.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityConvert {
    CityConvert INSTANCE = Mappers.getMapper(CityConvert.class);
    List<CityDto> citiesToCitiesDto(List<City> cities);

    CityDto cityToCityDto(City city);

    City cityDtoToCity(CityDto cityDto);


}
