package com.young.coursera.city.domain;

import com.young.coursera.core.persist.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class City extends BaseEntity {
    private Long id;

    private String name;

    private String state;

    private String country;
}
