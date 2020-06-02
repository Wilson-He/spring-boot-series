package io.mybatis.plus;

import io.mybatis.plus.entity.State;
import io.mybatis.plus.entity.UserBase;
import io.mybatis.plus.mapper.UserBaseMapper;
import io.mybatis.plus.service.UserBaseService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author ex_hewx
 * @date 2020/4/27
 */
@SpringBootApplication
@MapperScan(basePackageClasses = UserBaseMapper.class)
public class MybatisTestApplication {
    @Resource
    private UserBaseMapper userBaseMapper;

    @PostConstruct
    public void init(){
        UserBase userBase = new UserBase()
                .setState(State.YES)
                .setUsername("test");
        userBaseMapper.insert(userBase);
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisTestApplication.class, args);
    }
}
