package com.young.coursera.city.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.young.coursera.city.convert.CityConvert;
import com.young.coursera.city.domain.dto.CityDto;
import com.young.coursera.city.domain.model.City;
import com.young.coursera.city.domain.dto.CityPageQuery;
import com.young.coursera.city.service.CityService;
import com.young.coursera.core.exception.enums.CommonError;
import com.young.coursera.core.exception.util.Asserts;
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
    //private final CityConvert CityConvert.INSTANCE;

    @Operation(summary = "新增city")
    @Parameter(name = "city", description = "city对象")
    @PostMapping
    public CityDto insert(@RequestBody CityDto cityDto) {
        City city = CityConvert.INSTANCE.cityDtoToCity(cityDto);
        City savedCity = cityService.insert(city);
        return CityConvert.INSTANCE.cityToCityDto(savedCity);
    }

    @Operation(summary = "更新city")
    @Parameter(name = "id", description = "city id")
    @Parameter(name = "city", description = "city对象")
    @PutMapping("/{id}")
    public CityDto update(@PathVariable("id") Long id, @RequestBody CityDto cityDto) {
        City city = CityConvert.INSTANCE.cityDtoToCity(cityDto);
        City savedCity = cityService.update(id, city);
        return CityConvert.INSTANCE.cityToCityDto(savedCity);
    }

    @Operation(summary = "删除city，只有创建者可以删除，否则抛出异常")
    @Parameter(name = "id", description = "city id")
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        cityService.delete(id);
        return true;
    }

    @Operation(summary = "根据id获取city对象")
    @Parameter(name = "id", description = "city id")
    @GetMapping("/{id}")
    public CityDto find(@PathVariable("id") Long id) {
        City city = cityService.findById(id);
        return CityConvert.INSTANCE.cityToCityDto(city);
    }

    @Operation(summary = "根据state获取city对象")
    @Parameter(name = "state", description = "city state")
    @GetMapping("/state/{state}")
    public CityDto findByState(@PathVariable("state") String state) {
        City city = cityService.findByState(state);
        return CityConvert.INSTANCE.cityToCityDto(city);
    }

    @Operation(summary = "根据查询条件获取city列表")
    @Parameter(name = "query", description = "city列表查询对象")
    @GetMapping("/search")
    public List<CityDto> search(@RequestBody Query query) {
        // 可以设置默认的返回条数,不查询分页总数
        PageHelper.startPage(1, 10, false);

        List<City> cities = cityService.findAll(query);
        log.info("Total:{} ", cities.size());
        return CityConvert.INSTANCE.citiesToCitiesDto(cities);
    }

    @Operation(summary = "根据查询条件获取city分页对象")
    @Parameter(name = "pageQuery", description = "city分页查询对象")
    @GetMapping("/page")
    public PageInfo<CityDto> page(@RequestBody CityPageQuery pageQuery) {
        // PageHelper.startPage(pageQuery.getPage(), pageQuery.getPageSize());
        List<City> cities = cityService.findForPage(pageQuery);
        PageInfo<CityDto> result = new PageInfo<>(CityConvert.INSTANCE.citiesToCitiesDto(cities));
        log.info("Total:{} ", result.getPageNum());
        return result;
    }

    @Operation(summary = "发布city")
    @Parameter(name = "id", description = "city id")
    @PostMapping("/publish/{id}")
    public Boolean publish(@PathVariable Long id) {
        cityService.publish(id, Boolean.TRUE);
        return true;
    }

    @Operation(summary = "取消发布city")
    @Parameter(name = "id", description = "city id")
    @DeleteMapping("/publish/{id}")
    public Boolean revokePublish(@PathVariable Long id) {
        cityService.publish(id, Boolean.TRUE);
        return true;
    }


}
