package com.young.coursera.city.domain.model;

import com.young.coursera.core.lang.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Schema(description="product")
@NoArgsConstructor
public class Product implements Serializable {
    @Schema(description = "商品id")
    private Long id;

    @Schema(description = "商品名称")
    private String name;

    @Schema(description = "商品价格")
    private Integer price;
}