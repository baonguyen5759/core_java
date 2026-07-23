package com.bao.core_java.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RaceConditionExample {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    void main() throws InterruptedException {
        RaceConditionExample example = new RaceConditionExample();

        Runnable task = () -> {
            for (int i=0; i<1000; i++) {
                example.increment();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        log.info("Final count: {}", example.getCount());
    }
}
