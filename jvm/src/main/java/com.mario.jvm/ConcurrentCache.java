package com.mario.jvm;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 热点缓存
 * @param <K>
 * @param <V>
 */
// 代码来自于：org.apache.tomcat.util.collections.ConcurrentCache.java
public final class ConcurrentCache<K,V> {

    private final int size;
    private final Map<K,V> eden;
    private final Map<K,V> longterm;

    public ConcurrentCache(int size) {
        this.size = size;
        this.eden = new ConcurrentHashMap<>(size);
        this.longterm = new WeakHashMap<>(size);
    }
    // 先从ConcurrentHashMap中取值，取不到就在WeakHashMap中取值
    public V get(K k) {
        V v = this.eden.get(k);
        if (v == null) {
            synchronized (longterm) {
                v = this.longterm.get(k);
            }
            // 如果在WeakHashMap取到值以后，在放入ConcurrentHashMap中
            if (v != null) {
                this.eden.put(k, v);
            }
        }
        return v;
    }
    // 如果ConcurrentHashMap已满，则把所有的数据放到WeakHashMap中，并清空自己
    public void put(K k, V v) {
        if (this.eden.size() >= size) {
            synchronized (longterm) {
                this.longterm.putAll(this.eden);
            }
            this.eden.clear();
        }
        // 如果ConcurrentHashMap未满，直接放入ConcurrentHashMap中
        this.eden.put(k, v);
    }
}
