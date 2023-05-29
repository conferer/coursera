package com.young.coursera.city.domain.model;

import com.young.coursera.core.lang.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description="orderitem")
@NoArgsConstructor
public class OrderItem implements Entity {
    @Schema(description = "订单详情号")
    private Long id;

    @Schema(description = "订单号")
    private Long orderId;

    @Schema(description = "商品名称")
    private String productName;

    @Schema(description = "商品价格")
    private Integer productPrice;
}