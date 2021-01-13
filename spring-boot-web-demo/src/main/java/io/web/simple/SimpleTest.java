package io.web.simple;

import org.springframework.util.DigestUtils;

/**
 * @author Wilson
 * @since 2020/2/28
 **/
public class SimpleTest {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex("111111".getBytes()));
    }
}
