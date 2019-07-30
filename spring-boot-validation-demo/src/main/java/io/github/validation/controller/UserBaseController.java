package io.github.validation.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.validation.group.InsertGroup;
import io.github.validation.group.UpdateGroup;
import io.github.validation.vo.UserVO;
import io.swagger.annotations.Api;
import org.springframework.integration.support.json.BoonJsonObjectMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/userBase")
@Api
public class UserBaseController {
    @Resource
    private Validator validator;
    private static final String VALIDATE_FORMAT = "%s%s";
    @Resource
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() throws Exception {
        System.out.println(new BoonJsonObjectMapper().toJsonNode(new UserVO().setPassword("111")));
        ((JSONObject) JSONObject.toJSON(new UserVO().setPassword("111"))).getInnerMap();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "aaa");
        map.put("age", null);
        map.put("sex", 1);
        System.out.println(map);
        System.out.println(new BoonJsonObjectMapper().toJsonNode(map));
    }

    /**
     * 添加用户
     *
     * @param vo {@link UserVO}
     * @return {@link UserVO}
     */
    @PostMapping("/")
    public UserVO add(@RequestBody @Validated(InsertGroup.class) UserVO vo) {
        return vo;
    }

    @PutMapping("/")
    public UserVO update(@RequestBody @Validated(UpdateGroup.class) UserVO vo) {
        return vo;
    }
}

