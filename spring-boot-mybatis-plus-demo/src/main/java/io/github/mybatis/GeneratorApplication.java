package io.github.mybatis;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.mysql.cj.jdbc.Driver;

/**
 * @author: Wilson
 * @date: 2019/4/22
 **/
public class GeneratorApplication {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/spring-boot-mybatis-plus-demo/output/src/main/java";
        String dbUrl = "jdbc:mysql://localhost:3306/wilson?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        AutoGenerator generator = new AutoGenerator();
        generator
                .setDataSource(dataSourceConfig(dbUrl, "root", "tiger", Driver.class))
                // 设置全局配置
                .setGlobalConfig(globalConfig(path, "Wilson"))
                // 设置各层文件的生成目录
                .setPackageInfo(packageConfig("io.github.mybatis.generate"))
                // 策略配置项
                .setStrategy(strategyConfig())
                // 选择模板引擎
                .setTemplateEngine(new FreemarkerTemplateEngine())
                // 设置文件模板路径,默认mybatis-plus-generator的templates目录下的模板文件,设为空则不生成对应目录及文件,如下不生成controller目录与文件
                // 自定义模板文件名不能与默认templates下的模板同名(仅大小写不同也会报模板找不到)
                .setTemplate(new TemplateConfig().setController(null).setEntity("/templates/custom-entity.java"))
                .execute();
    }

    private static PackageConfig packageConfig(String basePackage) {
        return new PackageConfig()
//                .setMapper("infrastructure.repository")
//                .setXml("mappers")
                // 设置所有生成所在的根包
                .setParent(basePackage);
    }

    private static DataSourceConfig dataSourceConfig(String url, String username, String password, Class driverClass) {
        return new DataSourceConfig()
                .setUrl(url)
                .setUsername(username)
                .setPassword(password)
                .setDriverName(driverClass.getCanonicalName());
    }

    private static StrategyConfig strategyConfig() {
        return new StrategyConfig()
                // 命名下划线转驼峰式
                .setNaming(NamingStrategy.underline_to_camel)
                // 设置只生成指定表的entity、mappers... exclude则设置不生成的表
//                .setInclude("user_base")
                // 生成的entity是否使用lombok注解
                .setEntityLombokModel(true)
                // 使用@RestController而非@Controller
                .setRestControllerStyle(true)
                // 设置逻辑删除字段,对应属性自动添加@TableLogic注解
                .setLogicDeleteFieldName("is_delete");
    }

    private static GlobalConfig globalConfig(String path, String author) {
        return new GlobalConfig()
                .setOutputDir(path)
                // 设置生成文件的命名格式
                .setServiceName("%sService")
                .setAuthor(author)
                // 设置生成的日期类型,默认TIME_PACK-jdk1.8的日期类型, ONLY_DATE-java.util.Date
                .setDateType(DateType.ONLY_DATE)
                // 设置@TableId注解的type
                .setIdType(IdType.AUTO)
                // 设置是否生成swagger注解,默认false
                .setSwagger2(false);
    }
}
