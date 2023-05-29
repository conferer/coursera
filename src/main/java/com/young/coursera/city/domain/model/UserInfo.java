package com.young.coursera.city.domain.model;

import com.young.coursera.core.lang.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description="userinfo")
@NoArgsConstructor
public class UserInfo implements Entity {
    @Schema(description = "用戶id")
    private Long id;

    @Schema(description = "用戶姓名")
    private String name;

    @Schema(description = "用戶性別")
    private String sex;

    @Schema(description = "用戶年齡")
    private Integer age;
}