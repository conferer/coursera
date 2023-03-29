package com.young.coursera.city.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.young.coursera.core.lang.Entity;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.time.Instant;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description="city")
@NoArgsConstructor
public class City implements Entity {
    @Serial
    private static final long serialVersionUID = -1768495284643688668L;

    private Long id;

    private String name;

    private String state;

    private String country;

    @Schema(description = "创建时间")
    private Instant createTime;

    @Schema(description = "更新时间")
    private Instant updateTime;
}