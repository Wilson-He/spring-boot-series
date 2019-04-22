package io.github.jackson;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author: Wilson
 * @date: 2019/4/19
 **/
@AllArgsConstructor
public class HashMapProxy<K, V> {
    private Map<K, V> map;

    public HashMapProxy() {
        this.map = new HashMap<>();
    }

    public HashMapProxy(int size) {
        this.map = new HashMap<>();
    }

    public static <K, V> HashMapProxy<K, V> from(Map<K, V> map) {
        return new HashMapProxy<>(map);
    }

    public HashMapProxy<K, V> put(K key, V val) {
        this.map.put(key, val);
        return this;
    }

    public HashMapProxy<K, V> put(boolean condition, K key, V val) {
        if (condition) {
            this.map.put(key, val);
        }
        return this;
    }

    public HashMapProxy<K, V> clear() {
        this.map.clear();
        return this;
    }

    public HashMapProxy<K, V> remove(K key) {
        this.map.remove(key);
        return this;
    }

    public V removeReturn(K key) {
        return this.map.remove(key);
    }

    public HashMapProxy<K, V> foreach(BiConsumer<K, V> biConsumer) {
        map.forEach(biConsumer);
        return this;
    }

    public Map<K, V> getMap() {
        return this.map;
    }

    @Override
    public String toString() {
        return map.toString();
    }

    public static void main(String[] args) {
        System.out.println(HashMapProxy.from(new HashMap<String, String>(12))
                .put("name", "Wilson")
                .put("age", "22")
                .getMap());
        System.out.println(new HashMapProxy<String, String>()
                .put("name", "Wilson")
                .put("sex", "1")
                .getMap());
    }
}

