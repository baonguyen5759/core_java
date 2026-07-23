package com.bao.core_java.threads.counter;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicRequestCounter {

    // lock-free, non-blocking algorithm called CAS (Compare-And-Swap)
    // Better throughput than synchronized for many workloads
    private final AtomicLong count = new AtomicLong();

    public void increment() {
        count.incrementAndGet();
    }

    public long getCount() {
        return count.get();
    }
}
