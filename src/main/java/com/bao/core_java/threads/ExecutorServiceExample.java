package com.bao.core_java.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ExecutorService is a high-level interface in Java Concurrency API for managing and executing
 * asynchronous tasks.
 * Key benefits:
 * - Improve performance: it reuses existing threads from a pool to execute tasks,
 *                        avoid overhead of creating a new thread for every task
 * - Resource management: it provides control over the number of active threads,
 *                        preventing resource exhaustion if an un-limited of threads are created
 * - Decoupling: it separates the submission of a task and how the task will be run
 * - Lifecycle management: it provides method to gracefully shut down the threads,
 *                         wait for the tasks to complete, and manage overall lifecycle of the
 *                         execution process.
 * We typically use the factory methods in the Excecutors class to create an ExecutorService
 *   - Executors.newFixedThreadPool(int nThreads): create a thread pool that reused a fixed
 *                                                 number of threads
 *   - Executors.newCachedThreadPool(): create a thread pool that creates new threads as needed
 *                          but will reuse previously constructed threads when they're available
 *   - Executors.newSingleThreadExecutor(): use a single worker thread
 */

@Slf4j
public class ExecutorServiceExample {
    void main() {
        // 1. Creating Executor Service with a fix pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 2. Define a task (as a Runnable)
        Runnable task = () -> {
            log.info("Executing task in thread: {}", Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // 3. Submit the task for execution
        log.info("Submitting tasks....");
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);

        // 4. Shutdown the executor
        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        log.info("All tasks finished.");
    }
}
