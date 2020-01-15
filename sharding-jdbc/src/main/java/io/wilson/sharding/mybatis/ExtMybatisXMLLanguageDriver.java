package io.wilson.sharding.mybatis;

import com.baomidou.mybatisplus.core.MybatisDefaultParameterHandler;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;

import java.lang.reflect.Field;

/**
 * @author Wilson
 * @since 2020/1/13
 **/
public class ExtMybatisXMLLanguageDriver extends MybatisXMLLanguageDriver {
    private final Field sqlField;

    public ExtMybatisXMLLanguageDriver() throws NoSuchFieldException {
        Class boundSqlClass = BoundSql.class;
        sqlField = boundSqlClass.getDeclaredField("sql");
        try {
            sqlField.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public MybatisDefaultParameterHandler createParameterHandler(MappedStatement mappedStatement,
                                                                 Object parameterObject, BoundSql boundSql) {
        String sql = boundSql.getSql();
        try {
            sqlField.set(boundSql, sql.replaceAll("\r\n|\n", " ")
                    .replaceAll("\\s{2,}", " "));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return new MybatisDefaultParameterHandler(mappedStatement, parameterObject, boundSql);
    }
}
