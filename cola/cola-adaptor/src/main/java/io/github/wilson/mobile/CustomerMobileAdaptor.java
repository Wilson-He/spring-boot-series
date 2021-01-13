package io.github.wilson.mobile;

import java.math.BigDecimal;

/**
 * Customer Mobile Adaptor
 *
 * @author Frank Zhang
 * @date 2020-10-27 8:04 PM
 */
public class CustomerMobileAdaptor {
    public static void main(String[] args) {

        double a = 0.5250;
        double b = 0.5350;
        System.out.println(Math.round(b * 10000) - Math.round(a * 10000));
        System.out.println(Math.round(b * 10000) - Math.round(a * 10000) >= 100);
        System.out.println(BigDecimal.valueOf(b)
                .subtract(BigDecimal.valueOf(a))
                .multiply(BigDecimal.valueOf(100))
                .compareTo(BigDecimal.ONE)
        );
        System.out.println(Double.doubleToLongBits(b) - Double.doubleToLongBits(a));
    }
}
