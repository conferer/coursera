package com.young.coursera.city;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.young.coursera.city.model.City;
import com.young.coursera.city.service.CityService;
import com.young.coursera.core.exception.enums.CommonError;
import com.young.coursera.core.exception.util.Asserts;
import com.young.coursera.core.lang.PageQuery;
import com.young.coursera.core.lang.Query;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "城市API", description = "可以控制城市的增删改查")
public class CityController {

    private final CityService cityService;

    @GetMapping
    public City getCity(String state) {
        City city = cityService.findByState(state);
        //展示如何使用 Exception helper 简化异常
        Asserts.notNull(city, CommonError.NOT_FOUND);
        return city;
    }

    @GetMapping("/search")
    public List<City> search(@RequestBody Query query) {
        //可以设置默认的返回条数
        PageHelper.startPage(1, 10);
        
        List<City> cities = cityService.list(query);
        log.info("Total:{} ", cities.size());
        return cities;
    }

    @GetMapping("/page")
    public PageInfo page(@RequestBody PageQuery pageQuery) {
        //PageHelper.startPage(pageQuery.getPage(), pageQuery.getPageSize());
        List<City> cities = cityService.listForPage(pageQuery);
        PageInfo result = new PageInfo(cities);
        log.info("Total:{} ", result.getPageNum());
        return result;
    }

    @PostMapping()
    @Operation(summary = "Create city", description = "只能登录用调用此API")
    @Parameter(name = "city", description = "city object to be saved")
    public City create(@RequestBody City city) {
        cityService.create(city);
        return cityService.findByState(city.getState());
    }

}
