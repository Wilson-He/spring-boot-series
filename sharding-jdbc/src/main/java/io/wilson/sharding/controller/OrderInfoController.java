package io.wilson.sharding.controller;

import io.springframework.common.response.ServerResponse;
import io.wilson.sharding.service.OrderInfoService;
import io.wilson.sharding.vo.OrderVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 订单控制器
 * </p>
 *
 * @author
 * @since 2020-01-13
 */
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {
    @Resource
    private OrderInfoService orderInfoService;

    @PostMapping("/")
    public ServerResponse add(@Validated @RequestBody OrderVO vo) {
        return ServerResponse.success(orderInfoService.insert(vo.orderInfo()));
    }

    @PutMapping("/")
    public ServerResponse update(@Validated @RequestBody OrderVO vo) {
        return ServerResponse.success(orderInfoService.updateById(vo.orderInfo()));
    }

    @GetMapping("/")
    public ServerResponse get(@RequestParam Long id) {
        return ServerResponse.success(orderInfoService.findById(id));
    }

    @GetMapping("/list")
    public ServerResponse list() {
        return ServerResponse.success(orderInfoService.list());
    }
}
