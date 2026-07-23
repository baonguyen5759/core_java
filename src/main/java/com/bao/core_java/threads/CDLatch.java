package com.bao.core_java.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CDLatch {
    void main() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i=0; i<3; i++) {
            final int workerId = i;
            executor.submit(() -> {
               try {
                   log.info("Worker [{}] is starting work....", workerId);
                   Thread.sleep(1000 + (long)(Math.random() * 1000));
                   log.info("Worker [{}] has finished.", workerId);
               } catch (InterruptedException ie) {
                   Thread.currentThread().interrupt();
               } finally {
                   latch.countDown();
               }
            });
        }
        log.info("Main thread is waiting for worker threads to finish their jobs");
        latch.await();

        log.info("All worker threads have finished.");
        executor.shutdown();
    }
}
