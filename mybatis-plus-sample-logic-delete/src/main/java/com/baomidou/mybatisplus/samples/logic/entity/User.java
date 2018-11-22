package com.baomidou.mybatisplus.samples.logic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.samples.logic.terry.constant.ColumnConstant;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

    @TableId
    private Integer id;

    private String name;

    private Integer age;

    private String email;

    @TableField(ColumnConstant.SORT_COLUMN)
    private Integer sort;

    @TableField(ColumnConstant.ENABLE_COLUMN)
    private Boolean enable;

    @TableLogic
    @TableField(ColumnConstant.DELETED_COLUMN)
    private Boolean deleted;
}
