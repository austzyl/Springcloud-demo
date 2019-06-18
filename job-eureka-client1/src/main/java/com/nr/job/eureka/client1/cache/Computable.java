package com.nr.job.eureka.client1.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaleizhu on 2019/5/28.
 * description:
 */
public interface Computable<K, V> {
    V compute(K args) throws InterruptedException;
}

class CustomCompute implements Computable<String, Integer>{


    @Override
    public Integer compute(String args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return new Integer(args) + 1;
    }
}

class Memocache<K, V> implements Computable<K, V> {

    private final Map<K, V> cache = new ConcurrentHashMap<>();
    private final Computable<K, V> computable;

    public Memocache(Computable<K, V> c) {
        this.computable = c;
    }

    @Override
    public V compute(K args) throws InterruptedException {
        V result = (V) cache.get(args);
        if (result == null) {
            result = computable.compute(args);
            cache.put(args, result);
        }
        System.out.println("-----------------------------：" + cache);
        return result;

    }
}
class Test {
    public static void main(String[] args) throws InterruptedException {
        Computable<String ,Integer> memocache = new Memocache<>(new CustomCompute());
        new Thread(()->{
            try {
                memocache.compute("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                memocache.compute("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}