package io.github.ds.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 缴费记录表
 * </p>
 *
 * @author
 * @since 2019-07-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("payment_info")
public class PaymentInfo implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userName;

    /**
     * 0：未缴费
     * 1：已缴费
     */
    private Integer payStatus;

    /**
     * 缴费标准
     */
    private BigDecimal payStandard;

    /**
     * 缴费金额
     */
    private BigDecimal payAmount;

    /**
     * 缴费时间
     */
    private LocalDateTime payTime;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 缴费项目
     */
    private String projectName;

    /**
     * 缴费项目编码
     */
    private Integer projectCode;

    /**
     * 在职状态：0：离职（3、4、5、6、7）
     */
    private Integer jobStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 商品订单ID 外键
     */
    private Integer orderId;

}
