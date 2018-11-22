package com.baomidou.mybatisplus.samples.logic.terry.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.samples.logic.terry.method.Enable;
import com.baomidou.mybatisplus.samples.logic.terry.method.EnableById;
import com.baomidou.mybatisplus.samples.logic.terry.method.Sort;
import com.baomidou.mybatisplus.samples.logic.terry.method.SortById;

import java.util.List;

public class CustomSqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList() {
        List<AbstractMethod> methodList = super.getMethodList();
        methodList.add(new EnableById());
        methodList.add(new Enable());
        methodList.add(new SortById());
        methodList.add(new Sort());
        return methodList;
    }
}
