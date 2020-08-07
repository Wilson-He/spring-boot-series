package io.github.test.controller;


import com.google.common.collect.Lists;
import io.github.test.domain.entity.UserBase;
import io.github.test.model.UserVO;
import io.springframework.common.response.ServerResponse;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author
 * @since 2019-05-07
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private List<HttpMessageConverters> messageConverters;
    @Resource
    private Validator validator;
    @Resource
    private HttpServletRequest request;
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/")
    public Object add(@RequestBody UserBase userBase) {
        RestTemplate restTemplate = new RestTemplate(messageConverters.get(0).getConverters());
        HttpEntity<UserBase> entity = new HttpEntity<>(userBase);
        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8080/userBase/", entity, UserBase.class);
        return responseEntity.getBody();
    }

    @GetMapping("/")
    public String get() {
        validate(new UserVO());
        return "index";
    }


    @GetMapping("/hello")
    public String hello() {
        return "/test/hello";
    }


    @GetMapping("/rest")
    public ServerResponse rest() {
        List<Long> arrays = Lists.newArrayList(4885L, 4889L);
        String result = restTemplate.exchange("http://10.16.88.42/midea-uom-gateway/new-live/api/external/liveConfig/listStatusByIds", HttpMethod.POST, new HttpEntity<>(arrays), String.class)
                .getBody();
        return ServerResponse.success(result);
    }

    @PostMapping("/user")
    public String get(@RequestBody UserVO vo) {
        System.err.println(request.getHeader("Authorization"));
        validate(new UserVO());
        return "index";
    }

    private void validate(@Validated @RequestBody UserVO vo) {
        System.out.println(validateMsg(vo));
    }

    public <T> boolean validate(T t) {
        return validator.validate(t).isEmpty();
    }

    /**
     * 返回错误信息,没错则返回空
     *
     * @param t
     * @param <T>
     * @return
     */
    public <T> String validateMsg(T t) {
        Set<ConstraintViolation<T>> errors = validator.validate(t);
        if (errors == null || errors.isEmpty()) {
            return null;
        }
        ConstraintViolation<T> constraintViolation = errors.stream().findFirst().orElse(null);
        String message = constraintViolation.getMessage();
        return constraintViolation.getPropertyPath().toString() + " " + message.replace(";", "");
    }
}
