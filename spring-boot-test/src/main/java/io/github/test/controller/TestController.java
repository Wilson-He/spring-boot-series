package io.github.test.controller;


import io.github.test.domain.entity.UserBase;
import io.github.test.model.UserVO;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
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
@RequestMapping("/")
public class TestController {
    @Resource
    private List<HttpMessageConverters> messageConverters;
    @Resource
    private Validator validator;

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

    @PostMapping("/user")
    public String get(@RequestBody UserVO vo) {
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
