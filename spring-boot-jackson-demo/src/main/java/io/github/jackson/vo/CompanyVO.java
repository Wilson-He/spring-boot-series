package io.github.jackson.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * CompanyVO
 *
 * @author Wilson
 * @date 2019/4/21
 */
@Data
@Accessors(chain = true)
public class CompanyVO {
    private String companyName;
    @JsonFormat
    private Date createTime;
    private Integer employeeNum;
}
