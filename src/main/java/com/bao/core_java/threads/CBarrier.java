package com.bao.core_java.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CBarrier {
    void main() {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            log.info("Barrier tripped. All threads have arrived. Resuming....");
        });
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i=0; i<3; i++) {
            final int workerId = i;
            executor.submit(() -> {
               try {
                   log.info("Thread [{}] is doing part 1 of its work...", workerId);
                   Thread.sleep(1000 + (long)(Math.random() * 1000));
                   log.info("Thread [{}] has reached the barrier.", workerId);
                   barrier.await(); // wait for other threads

                   log.info("Thread [{}] is doing part 2 of its work...", workerId);
               } catch (InterruptedException | BrokenBarrierException e) {
                   Thread.currentThread().interrupt();
               }
            });
        }
        executor.shutdown();
    }
}
