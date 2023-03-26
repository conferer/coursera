package com.young.coursera.city.model;

import com.young.coursera.core.lang.PageQuery;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
@Getter
@Setter
public class CityPageQuery extends PageQuery {
    @Serial
    private static final long serialVersionUID = 5188492872405928203L;
    private String name;
    private String state;
    private String country;
}
