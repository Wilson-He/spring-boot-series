package io.github.jackson.controller;

import io.github.jackson.vo.CompanyVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * CompanyController
 *
 * @author Wilson
 * @date 2019/4/21
 */
@RestController
@RequestMapping("/company")
@Api
public class CompanyController {
    @PostMapping("/")
    public CompanyVO post(@RequestBody CompanyVO vo) {
        return vo;
    }

    @GetMapping("/")
    public CompanyVO get(@RequestParam String companyName) {
        return new CompanyVO().setCompanyName(companyName);
    }
}
