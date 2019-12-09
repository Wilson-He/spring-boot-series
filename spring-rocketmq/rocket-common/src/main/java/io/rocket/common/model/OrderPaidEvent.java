package io.rocket.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Wilson
 * @since 2019/11/26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPaidEvent implements Serializable {
    private String orderId;
    private BigDecimal paidMoney;
}
