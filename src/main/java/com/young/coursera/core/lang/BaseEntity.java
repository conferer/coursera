package com.young.coursera.core.lang;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

/**
 * 实体积累
 */
public class BaseEntity implements Serializable {

    @Schema(description = "创建时间")
    private Instant createTime;


    @Schema(description = "更新时间")
    private Instant updateTime;

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }
}
