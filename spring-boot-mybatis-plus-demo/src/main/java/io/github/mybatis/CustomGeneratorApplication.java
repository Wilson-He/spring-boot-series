package io.github.mybatis;

import io.github.generator.factory.DefaultGeneratorConfigFactory;

import java.io.IOException;

/**
 * CustomGeneratorApplication
 *
 * @author Wilson
 * @date 2019/5/4
 */
public class CustomGeneratorApplication {
    public static void main(String[] args) throws IOException {
        DefaultGeneratorConfigFactory.defaultAutoGenerator("application.yml", "io.github.test")
                .getStrategy()
                .setLogicDeleteFieldName("is_delete")
                // 不生成名称含Detail、Relation的Service、Controller
                .excludeKeywords("Detail", "Relation")
                .backGenerator()
                .getTemplateConfig()
                // 不生成常量类
                .excludeConstant()
                // 不生成Controller类
                .excludeController()
                .backGenerator()
                .execute();
    }
}
