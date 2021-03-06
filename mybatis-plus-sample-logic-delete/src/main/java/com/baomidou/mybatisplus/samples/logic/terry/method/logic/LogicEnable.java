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
import com.baomidou.mybatisplus.samples.logic.terry.enums.SqlMethodEnum;
import com.baomidou.mybatisplus.samples.logic.terry.utils.SqlSetUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * <p>
 * 根据 queryWrapper 删除
 * </p>
 *
 * @author hubin
 * @since 2018-06-13
 */
public class LogicEnable extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlMethodEnum sqlMethod = SqlMethodEnum.LOGIC_ENABLE;
        String sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(),
                SqlSetUtils.sqlEnableSet(true, tableInfo, Constants.ENTITY_SPOT),
                sqlWhereEntityWrapper(tableInfo), tableInfo.getLogicDeleteSql(true, false));
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return addUpdateMappedStatement(mapperClass, modelClass, sqlMethod.getMethod(), sqlSource);
    }
}
