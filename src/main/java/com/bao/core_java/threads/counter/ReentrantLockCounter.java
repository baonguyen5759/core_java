package com.bao.core_java.threads.counter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockCounter {
    private final ReentrantLock lock = new ReentrantLock();
    int count = 0;

    public void increment() {
        lock.lock(); // block indefinitely
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void incrementWithTryLock() {
        if (lock.tryLock()) {
            try {
                count++;
            } finally {
                lock.unlock();
            }
        } else {
            log.info("Lock is busy...");
        }
    }

    public void incrementWithTimedLock() throws InterruptedException {
        if (lock.tryLock(2, TimeUnit.SECONDS)) {
            try {
                count++;
            } finally {
                lock.unlock();
            }
        } else {
            log.info("Timeout");
        }
    }

    public int getCount() {
        return count;
    }
}
