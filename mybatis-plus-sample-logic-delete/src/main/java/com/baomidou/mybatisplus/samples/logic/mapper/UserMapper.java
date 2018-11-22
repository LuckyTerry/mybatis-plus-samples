package com.baomidou.mybatisplus.samples.logic.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.samples.logic.entity.User;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

public interface UserMapper extends BaseMapper<User> {

    int enable(@Param(Constants.ENTITY) User user, @Param(Constants.WRAPPER) Wrapper<User> wrapper);

    int enableById(@Param(Constants.ENTITY) User user);

    int sort(@Param(Constants.ENTITY) User user, @Param(Constants.WRAPPER) Wrapper<User> wrapper);

    int sortById(@Param(Constants.ENTITY) User user);
}
