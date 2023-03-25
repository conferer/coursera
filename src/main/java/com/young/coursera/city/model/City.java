package com.young.coursera.city.model;

import com.young.coursera.core.lang.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description="city")
@NoArgsConstructor
public class City  extends BaseEntity {
    private Long id;

    private String name;

    private String state;

    private String country;

}