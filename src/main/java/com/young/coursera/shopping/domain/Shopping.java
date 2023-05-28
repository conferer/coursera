package com.young.coursera.shopping.domain;

import com.young.coursera.core.lang.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description="shopping00")
@NoArgsConstructor
public class Shopping implements Entity {
    @Schema(description = "商品id")
    private Long shopingId;

    @Schema(description = "商品名称")
    private String shopingName;

    @Schema(description = "商品价格")
    private Integer shopingPrice;
}