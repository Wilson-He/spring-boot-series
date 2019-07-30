package io.github.ds;

import io.github.ds.domain.entity.OrderBase;
import io.github.ds.domain.entity.PaymentInfo;
import io.github.ds.domain.entity.UserBase;
import io.github.ds.service.OrderBaseService;
import io.github.ds.service.PaymentInfoService;
import io.github.ds.service.UserBaseService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wilson
 * @date 2019/7/10
 **/
@SpringBootApplication
@MapperScan("io.github.ds.mapper")
@RestController
public class MultiDatasourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceApplication.class, args);
    }

    @Resource
    private UserBaseService userBaseService;
    @Resource
    private OrderBaseService orderBaseService;
    @Resource
    private PaymentInfoService paymentInfoService;

    @GetMapping("/users")
    public List<UserBase> users() {
        return userBaseService.list();
    }

    @GetMapping("/userList")
    public List<UserBase> userList() {
        return userBaseService.selectList();
    }

    @GetMapping("/orders")
    public List<OrderBase> orders() {
        return orderBaseService.list();
    }

    @GetMapping("/orderList")
    public List<OrderBase> orderList() {
        return orderBaseService.selectList();
    }

    @GetMapping("/all")
    public List<OrderBase> all() {
        userBaseService.list();
        return orderBaseService.selectList();
    }

    @GetMapping("/paymentInfos")
    public List<PaymentInfo> paymentInfos() {
        return paymentInfoService.list();
    }
}
