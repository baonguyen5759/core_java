package com.bao.core_java.jdk21;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class VirtualThread {
    void main() {
        try {
            // Method 1
            Thread vt = Thread.ofVirtual().name("B**-thread").start(() -> {
                log.info("Hello from Virtual Thread {}", Thread.currentThread());
            });

            // Method 2
            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                IntStream.range(0, 10).forEach(i -> {
                    executor.submit(() -> {
                        log.info("Thread (Executor) {} will sleep for 1 second", i);
                        Thread.sleep(Duration.ofSeconds(1));
                        return i;
                    });
                });
            };
            log.info("All VT are done");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}
