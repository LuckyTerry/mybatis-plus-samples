package com.baomidou.mybatisplus.samples.generator.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BaseEntity {

    private Long id;
}
