package com.baomidou.mybatisplus.samples.logic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.samples.logic.entity.User;
import com.baomidou.mybatisplus.samples.logic.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testLogicDeleteById() {
        userMapper.deleteById(1);
    }

    @Test
    public void testLogicDeleteBatchIds() {
        userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
    }

    @Test
    public void testLogicDelete() {
        userMapper.delete(new QueryWrapper<User>().eq("age", 24));
    }

    @Test
    public void testLogicEnableById() {
        userMapper.enableById(new User().setId(4).setIsEnable(false));
    }

    @Test
    public void testLogicEnable() {
        userMapper.enable(new User().setIsEnable(true), new QueryWrapper<User>().eq("id", 4));
    }

    @Test
    public void testLogicSortById() {
        userMapper.sortById(new User().setId(1).setSort(1));
        userMapper.sortById(new User().setId(2).setSort(2));
        userMapper.sortById(new User().setId(3).setSort(3));
        userMapper.sortById(new User().setId(4).setSort(4));
        userMapper.sortById(new User().setId(5).setSort(5));
    }

    @Test
    public void testLogicSort() {
        userMapper.sort(new User().setSort(99), new QueryWrapper<User>().eq("id", 4));
    }
}
