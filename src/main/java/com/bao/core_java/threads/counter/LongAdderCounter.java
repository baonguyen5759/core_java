package com.bao.core_java.threads.counter;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderCounter {

    // Best for very high traffic
    // Different threads update different cells -> reduce contention and scales better
    private final LongAdder counter = new LongAdder();

    public void increment() {
        counter.increment();
    }

    public long getCount() {
        return counter.sum();
    }
}
