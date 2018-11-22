package com.baomidou.mybatisplus.samples.logic.terry.utils;

import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlScriptUtils;
import com.baomidou.mybatisplus.samples.logic.terry.constant.ColumnConstant;

public class SqlSetUtils {

    public static String sqlEnableSet(boolean ew, TableInfo tableInfo, String prefix) {
        return sqlSet(ew, tableFieldInfoByColumn(tableInfo, ColumnConstant.ENABLE_COLUMN), prefix);
    }

    public static String sqlSortSet(boolean ew, TableInfo tableInfo, String prefix) {
        return sqlSet(ew, tableFieldInfoByColumn(tableInfo, ColumnConstant.SORT_COLUMN), prefix);
    }

    private static String sqlSet(boolean ew, TableFieldInfo tableFieldInfo, String prefix) {
        String sqlScript = tableFieldInfo.getSqlSet(prefix);
        if (ew) {
            sqlScript += StringPool.NEWLINE;
            sqlScript += SqlScriptUtils.convertIf(SqlScriptUtils.unSafeParam(Constants.U_WRAPPER_SQL_SET),
                    String.format("%s != null and %s != null", Constants.WRAPPER, Constants.U_WRAPPER_SQL_SET), false);
        }
        return SqlScriptUtils.convertTrim(sqlScript, "SET", null, null, ",");
    }

    private static TableFieldInfo tableFieldInfoByColumn(TableInfo tableInfo, String column) {
        return tableInfo.getFieldList().stream()
                .filter(tableFieldInfo -> column.equals(tableFieldInfo.getColumn())).findFirst()
                .orElseThrow(() -> ExceptionUtils.mpe(String.format("can't find the filed [%s] from table [%s]", column, tableInfo.getTableName())));
    }
}
