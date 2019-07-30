package io.github.jackson.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jackson.vo.CompanyVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * CompanyController
 *
 * @author Wilson
 * @date 2019/4/21
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Resource
    private ObjectMapper objectMapper;

    @PostMapping("/")
    public CompanyVO post(@RequestBody CompanyVO vo) {
        return vo;
    }

    @GetMapping("/")
    public String objectToJson() throws JsonProcessingException {
        // 使用jackson的objectMapper将对象根据SNAKE_CASE策略转成json字符串
        return objectMapper.writeValueAsString(new CompanyVO().setCompanyName("company").setEmployeeNum(11));
    }
}
