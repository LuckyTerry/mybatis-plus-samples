package com.baomidou.mybatisplus.samples.logic.terry.enums;

public enum SqlMethodEnum {

    /**
     * 启用
     */
    ENABLE_BY_ID("enableById", "根据ID 启用一条数据", "<script>\nUPDATE %s %s WHERE %s=#{%s}\n</script>"),
    ENABLE("enable", "根据 entity 条件，启用记录", "<script>\nUPDATE %s %s %s\n</script>"),

    /**
     * 逻辑启用
     */
    LOGIC_ENABLE_BY_ID("enableById", "根据ID 逻辑启用一条数据", "<script>\nUPDATE %s %s WHERE %s=#{%s} %s\n</script>"),
    LOGIC_ENABLE("enable", "根据 entity 条件，逻辑启用记录", "<script>\nUPDATE %s %s %s %s\n</script>"),

    /**
     * 排序
     */
    SORT_BY_ID("sortById", "根据ID 排序一条数据", "<script>\nUPDATE %s %s WHERE %s=#{%s}\n</script>"),
    SORT("sort", "根据 entity 条件，排序记录", "<script>\nUPDATE %s %s %s\n</script>"),

    /**
     * 逻辑排序
     */
    LOGIC_SORT_BY_ID("sortById", "根据ID 逻辑排序一条数据", "<script>\nUPDATE %s %s WHERE %s=#{%s} %s\n</script>"),
    LOGIC_SORT("sort", "根据 entity 条件，逻辑排序记录", "<script>\nUPDATE %s %s %s %s\n</script>");

    private final String method;
    private final String desc;
    private final String sql;

    SqlMethodEnum(String method, String desc, String sql) {
        this.method = method;
        this.desc = desc;
        this.sql = sql;
    }

    public String getMethod() {
        return method;
    }

    public String getDesc() {
        return desc;
    }

    public String getSql() {
        return sql;
    }
}
