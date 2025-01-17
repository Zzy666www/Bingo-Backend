package com.bingo.utils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Author 徐志斌
 * 代码生成器
 */
public class CodeGenerator {
    public static void main(String[] args) {
        /**
         * 第一步：使用代码生成器
         */
        AutoGenerator autoGenerator = new AutoGenerator();
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://101.42.13.186:3306/bingo?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("Xuzhibin123.");
        autoGenerator.setDataSource(dataSource);
        /**
         * 第二步：设置全局配置
         */
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        globalConfig.setOpen(false);
        globalConfig.setAuthor("徐志斌");
        globalConfig.setFileOverride(true);
        globalConfig.setMapperName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setIdType(IdType.ASSIGN_ID);
        autoGenerator.setGlobalConfig(globalConfig);

        /**
         * 第三步：    设置包名相关配置
         */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.bingo");
        packageConfig.setEntity("pojo");
        packageConfig.setMapper("mapper");
        autoGenerator.setPackageInfo(packageConfig);

        /**
         * 第四步：   策略设置
         */
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("bingo_chat_group");
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        strategyConfig.setControllerMappingHyphenStyle(false);
        strategyConfig.setLogicDeleteFieldName("deleted");
        strategyConfig.setEntityLombokModel(true);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.execute();
    }
}