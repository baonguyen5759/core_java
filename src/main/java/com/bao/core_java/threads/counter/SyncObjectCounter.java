package com.bao.core_java.threads.counter;

public class SyncObjectCounter {

    private int count = 0;

    private final Object lock = new Object();

    public void increment() {
        synchronized (lock) {
            count++;
        } // release the lock
    }

    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }
}
