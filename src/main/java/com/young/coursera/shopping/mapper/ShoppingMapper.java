package com.young.coursera.shopping.mapper;

import com.young.coursera.shopping.domain.Shopping;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingMapper {
    int deleteById(Long shopingId);

    int insert(Shopping row);

    Shopping findById(Long shopingId);

    List<Shopping> findAll();

    int update(Shopping row);
}