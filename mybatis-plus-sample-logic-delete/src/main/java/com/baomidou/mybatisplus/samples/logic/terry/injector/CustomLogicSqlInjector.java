package com.baomidou.mybatisplus.samples.logic.terry.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.samples.logic.terry.method.logic.LogicEnable;
import com.baomidou.mybatisplus.samples.logic.terry.method.logic.LogicEnableById;
import com.baomidou.mybatisplus.samples.logic.terry.method.logic.LogicSort;
import com.baomidou.mybatisplus.samples.logic.terry.method.logic.LogicSortById;

import java.util.List;

public class CustomLogicSqlInjector extends LogicSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList() {
        List<AbstractMethod> methodList = super.getMethodList();
        methodList.add(new LogicEnableById());
        methodList.add(new LogicEnable());
        methodList.add(new LogicSortById());
        methodList.add(new LogicSort());
        return methodList;
    }
}
