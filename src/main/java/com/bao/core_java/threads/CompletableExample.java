package com.bao.core_java.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class CompletableExample {

    void main() {

        // Execute a task that return a value
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 5);

        // thenApply: transform the result of a future. It takes the result, applies a funtion to it and return
        // a new CompletableFuture with the transformed result
        CompletableFuture<String> applyFuture = future.thenApply(result -> "Future result is: " + result);
        applyFuture.thenAccept(System.out::println);
        applyFuture.join();

        // thenCompose: chains a dependent future. Use this when the next asynchronous operation depends on
        // the result of the first one
        CompletableFuture<String> composeFuture = future.thenCompose(result -> CompletableFuture.supplyAsync(() -> "Compose result is: " + (result * 3)));
        composeFuture.thenAccept(System.out::println);
        composeFuture.join();

        // thenCombine: combine the results of two independent futures when both are complete.
        CompletableFuture<String> combineFuture = future.thenCombine(CompletableFuture.supplyAsync(() -> "10"), (s1, s2) -> "Combine result is: " + s1 + " - " + s2);
        combineFuture.thenAccept(System.out::println);
        combineFuture.join();
    }
}
