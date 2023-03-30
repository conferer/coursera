package com.young.coursera.city.domain.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
public class CityDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 4986414455612902917L;
    private Long id;

    private String name;

    private String state;

    private String country;

    private Instant createTime;

    private Instant updateTime;
}
