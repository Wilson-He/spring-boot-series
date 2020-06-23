package io.wilson.basic.collection;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.RandomStringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ex_hewx
 * @date 2020/6/3
 */
public class HashMapTest {

    public static void main(String[] args) throws Exception {
        stringKey();
    }

    public static void stringKey() throws NoSuchFieldException, IllegalAccessException {
        HashMap<String, Integer> map = new HashMap<>(33);
        // 9个hashKey相同的字符串集合，map容量<64时会在添加第9个"20kf"进行扩容,如初始32则左移一位为64,集合删除"20kf"则不会扩容仍为32
        Set<String> sameHashKeys = Sets.newHashSet("30lG", "31MG", "31Lf", "30kf", "1nlG", "2PLf", "1oLf", "2OlG", "2Okf");
        Field thresholdField = HashMap.class.getDeclaredField("threshold");
        Field tableField = HashMap.class.getDeclaredField("table");
        thresholdField.setAccessible(true);
        tableField.setAccessible(true);
        Random random = new Random();
        IntStream.range(0, 10).forEach(i -> map.put(String.valueOf(i), i));
        sameHashKeys.forEach(key -> map.put(key, random.nextInt(25)));
        Set<Map.Entry<String, Integer>> sets = map.entrySet();
        Map.Entry<String, Integer>[] table = (Map.Entry<String, Integer>[]) tableField.get(map);
        long notNullCount = Arrays.stream(table)
                .filter(Objects::nonNull)
                .count();
        Set<Class> nodeClasses = Arrays.stream(table)
                .filter(Objects::nonNull)
                .map(Object::getClass)
                .collect(Collectors.toSet());
        // 输出格式化
        String tableString = JSONObject.toJSONString(table)
                .replaceAll(",null", "")
                .replaceAll("null,", "")
                .replaceAll("\\{|}|\"", "")
                .replaceAll(":", "=")
                .replaceAll(",", ", ");
        System.out.println("map.size():" + map.size() + ", table.length: " + table.length
                + ", table node count: " + notNullCount + ", entrySet size: " + sets.size());
        System.err.println("node classes: " + nodeClasses);
        map.remove("30lG");
        System.out.println("table:  " + JSONObject.toJSONString(table));
        System.out.println("evict null table: " + tableString);
        System.out.println("entrySet: " + sets);
    }

    /**
     * 9个随机生成的hashKey相同的字符串集合
     *
     * @return
     */
    public static Set<String> sameHashKeys() {
        return Sets.newHashSet("30lG", "31MG", "31Lf", "30kf", "1nlG", "2PLf", "1oLf", "2OlG", "2Okf");
    }

    public static Set<String> randomString() {
        Set<String> sameHashs = new HashSet<>(10);
        int hash = 0;
        Random random = new Random();
        while (sameHashs.size() < 9) {
            String tmp = RandomStringUtils.randomAlphabetic(random.nextInt(4)) + random.nextInt(99)
                    + RandomStringUtils.randomAlphabetic(random.nextInt(4));
            if (hash == 0) {
                hash = tmp.hashCode();
            } else if (tmp.hashCode() == hash) {
                sameHashs.add(tmp);
            }
        }
        return sameHashs;
    }
}
