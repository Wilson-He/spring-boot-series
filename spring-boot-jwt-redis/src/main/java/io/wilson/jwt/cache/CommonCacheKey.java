package io.wilson.jwt.cache;

/**
 * @author Wilson
 * @date 2019/11/5
 **/
public class CommonCacheKey extends AbstractCacheKeyPrefix {

    private CommonCacheKey(String prefix) {
        super(3600 * 24, prefix + "%s");
    }

    public static CommonCacheKey TOKEN_USER = new CommonCacheKey("token:admin:");

    public String key(Object value) {
        return String.format(prefix(), value);
    }

    public CommonCacheKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static CommonCacheKey TOKEN_ADMIN = new CommonCacheKey("token:admin:");
}
