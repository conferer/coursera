package com.young.coursera.core.persist.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class BaseEntity {
    /**
     * 创建时间
     */
    private Instant createTime;

    /**
     * 最后更新时间
     */
    private Instant updateTime;
}
