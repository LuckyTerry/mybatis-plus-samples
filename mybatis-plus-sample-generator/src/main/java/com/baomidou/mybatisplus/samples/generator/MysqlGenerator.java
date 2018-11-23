package com.baomidou.mybatisplus.samples.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * mysql 代码生成器演示例子
 * </p>
 *
 * @author jobob
 * @since 2018-09-12
 */
public class MysqlGenerator {

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        basicConfig().execute();
    }

    private static AutoGenerator basicConfig() {
        String projectPath = System.getProperty("user.dir");
        String moduleName = scanner("模块名");
        String pkgName = "com.baomidou.mybatisplus.samples.generator";
        String javaPath = "/mybatis-plus-sample-generator/src/main/java";
        String mapperPath = "/mybatis-plus-sample-generator/src/main/resources/mapper/";
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setDataSource(dataSourceConfig());
        autoGenerator.setStrategy(strategyConfig(moduleName, pkgName));
        autoGenerator.setPackageInfo(packageInfoConfig(moduleName, pkgName));
        autoGenerator.setTemplate(templateConfig());
        autoGenerator.setTemplateEngine(templateEngineConfig());
        autoGenerator.setGlobalConfig(globalConfig(projectPath, javaPath));
        autoGenerator.setCfg(injectionConfig(projectPath, moduleName, mapperPath));
        return autoGenerator;
    }

    private static DataSourceConfig dataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 数据库信息查询类，默认由 dbType 类型决定选择对应数据库内置实现
        dataSourceConfig.setDbQuery(new MySqlQuery());
        // 数据库类型
        dataSourceConfig.setDbType(DbType.MYSQL);
        // 数据库 schema name
//        dsc.setSchemaName("public");
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
        // 驱动连接的URL
        dataSourceConfig.setUrl("jdbc:mysql://192.168.100.135:3308/mybatis_plus_db?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // 驱动名称
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        // 数据库连接用户名
        dataSourceConfig.setUsername("root");
        // 数据库连接密码
        dataSourceConfig.setPassword("mysqlHolder");

        return dataSourceConfig;
    }

    private static StrategyConfig strategyConfig(String moduleName, String pkgName) {
        StrategyConfig strategyConfig = new StrategyConfig();
        // 是否大写命名
        strategyConfig.setCapitalMode(false);
        // 是否跳过视图
        strategyConfig.setSkipView(false);
        // 数据库表映射到实体的命名策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 表前缀
        strategyConfig.setTablePrefix(moduleName + "_");
        // 字段前缀
//        strategyConfig.setFieldPrefix();
        // 自定义继承的Entity类全称，带包名
//        strategyConfig.setSuperEntityClass(pkgName + ".entity.BaseEntity");
        // 自定义基础的Entity类，公共字段
//        strategyConfig.setSuperEntityColumns("id");
        // 自定义继承的Mapper类全称，带包名
//        strategyConfig.setSuperMapperClass();
        // 自定义继承的Service类全称，带包名
//        strategyConfig.setSuperServiceClass();
        // 自定义继承的ServiceImpl类全称，带包名
//        strategyConfig.setSuperServiceImplClass();
        // 自定义继承的Controller类全称，带包名
//        strategyConfig.setSuperControllerClass(pkgName + ".controller.BaseController");
        // 需要包含的表名，允许正则表达式（与exclude二选一配置）
        strategyConfig.setInclude(scanner("表名"));
        // 需要排除的表名，允许正则表达式
//        strategyConfig.setExclude("");
        // 【实体】是否生成字段常量（默认 false）
        strategyConfig.setEntityColumnConstant(false);
        // 【实体】是否为构建者模型（默认 false）
        strategyConfig.setEntityBuilderModel(false);
        // 【实体】是否为lombok模型（默认 false）
        strategyConfig.setEntityLombokModel(true);
        // Boolean类型字段是否移除is前缀（默认 false）
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(true);
        // 生成 @RestController 控制器
        strategyConfig.setRestControllerStyle(true);
        // 驼峰转连字符
        strategyConfig.setControllerMappingHyphenStyle(true);
        // 乐观锁属性名称
//        strategyConfig.setVersionFieldName();
        // 逻辑删除属性名称
        strategyConfig.setLogicDeleteFieldName("is_deleted");
        // 表填充字段
//        strategyConfig.setTableFillList();

        return strategyConfig;
    }

    private static PackageConfig packageInfoConfig(String moduleName, String pkgName) {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(pkgName);
        packageConfig.setModuleName(moduleName);
        return packageConfig;
    }

    private static TemplateConfig templateConfig() {
        return new TemplateConfig().setXml(null);
    }

    private static AbstractTemplateEngine templateEngineConfig() {
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        return new FreemarkerTemplateEngine();
    }

    private static GlobalConfig globalConfig(String projectPath, String javaPath) {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(projectPath + javaPath);
        globalConfig.setAuthor("terry");
        globalConfig.setOpen(false);
        return globalConfig;
    }

    private static InjectionConfig injectionConfig(String projectPath, String moduleName, String mapperPath) {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
        fileOutConfigs.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + mapperPath
                        + moduleName + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigs);

        return injectionConfig;
    }

    /**
     * 读取控制台内容
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("请输入" + tip + "："));
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
