package com.baomidou.mybatisplus.samples.logic.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private Integer sort;
    private Boolean isEnable;
    @TableLogic
    private Boolean isDeleted;
}
