package com.bao.core_java.threads.counter;

public class SyncCounter {

    // Lock contention under high traffic
    // Use intrinsic locks (monitor lock)
    // Only 1 thread enters the method at a time
    private int count;

    public synchronized void increment() {
        count++;
    }
    public synchronized int getCount() {
        return count;
    }
}