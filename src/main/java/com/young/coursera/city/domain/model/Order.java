package com.young.coursera.city.domain.model;

import com.young.coursera.core.lang.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Schema(description="order")
@NoArgsConstructor
public class Order implements Serializable {
    @Schema(description = "订单号")
    private Long id;

    @Schema(description = "订单总金额")
    private Integer price;

    @Schema(description = "用戶id")
    private Long userId;
}