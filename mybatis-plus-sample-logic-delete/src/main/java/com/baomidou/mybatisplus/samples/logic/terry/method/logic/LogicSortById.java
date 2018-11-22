/*
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.samples.logic.terry.method.logic;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.samples.logic.terry.enums.SqlMethodEnum;
import com.baomidou.mybatisplus.samples.logic.terry.utils.SqlSetUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * <p>
 * 根据 ID 排序
 * </p>
 *
 * @author hubin
 * @since 2018-06-13
 */
public class LogicSortById extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql;
        boolean logicDelete = tableInfo.isLogicDelete();
        SqlMethodEnum sqlMethod = SqlMethodEnum.LOGIC_SORT_BY_ID;
        StringBuilder append = new StringBuilder("<if test=\"et instanceof java.util.Map\">")
                .append("<if test=\"et.").append(OptimisticLockerInterceptor.MP_OPTLOCK_VERSION_ORIGINAL).append("!=null\">")
                .append(" AND ${et.").append(OptimisticLockerInterceptor.MP_OPTLOCK_VERSION_COLUMN)
                .append("}=#{et.").append(OptimisticLockerInterceptor.MP_OPTLOCK_VERSION_ORIGINAL).append(StringPool.RIGHT_BRACE)
                .append("</if></if>");
        if (logicDelete) {
            append.append(tableInfo.getLogicDeleteSql(true, false));
        }
        sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(),
                SqlSetUtils.sqlSortSet(false, tableInfo, Constants.ENTITY_SPOT),
                tableInfo.getKeyColumn(), Constants.ENTITY_SPOT + tableInfo.getKeyProperty(),
                append);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return addUpdateMappedStatement(mapperClass, modelClass, sqlMethod.getMethod(), sqlSource);
    }
}
