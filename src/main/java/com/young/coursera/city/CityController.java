package com.young.coursera.city;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.young.coursera.city.model.City;
//import com.young.coursera.city.mapper.CityMapper;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cities")
@RequiredArgsConstructor
@PermitAll
@Slf4j
public class CityController {

    //private final CityMapper cityMapper;

    //@GetMapping
    //public City getCity(String state) {
    //    return cityMapper.findByState(state);
    //}
    //@GetMapping("/search")
    //public PageInfo search() {
    //    PageHelper.startPage(1, 20);
    //    List<City> cities = cityMapper.selectAll();
    //    PageInfo page = new PageInfo(cities);
    //    log.info("Total:{} ", page.getPageNum());
    //    return page;
    //}
    //
    //@GetMapping("/page")
    //public PageInfo page(int page, int pageSize) {
    //    List<City> cities = cityMapper.selectAll(page, pageSize);
    //    PageInfo result = new PageInfo(cities);
    //    log.info("Total:{} ", result.getPageNum());
    //    return result;
    //}
    //
    //@PostMapping()
    //public City create(@RequestBody City city) {
    //    cityMapper.insert(city);
    //    return cityMapper.findByState(city.getState());
    //}

}
