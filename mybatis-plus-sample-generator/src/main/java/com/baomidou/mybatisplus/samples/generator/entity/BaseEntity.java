package com.baomidou.mybatisplus.samples.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BaseEntity {

    @TableId
    private Long id;
}
