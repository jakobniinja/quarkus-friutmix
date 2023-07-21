package org.acme.utils;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Counter {
    private int val;

    public Counter() {
        val = 0;
    }

    public void increment() {
        ++val;
    }

    public void decrement() {
        --val;
    }

    public int getVal() {
        return val;
    }
}
