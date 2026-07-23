package com.bao.core_java.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class CompletableExample {

    void main() {

        // thenApply
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 5);
        CompletableFuture<String> applyFuture = future.thenApply(result -> "Future result is: " + result);
        applyFuture.thenAccept(System.out::println);
        applyFuture.join();

        // thenCompose
        CompletableFuture<String> composeFuture = future.thenCompose(result -> CompletableFuture.supplyAsync(() -> "Compose result is: " + (result * 3)));
        composeFuture.thenAccept(System.out::println);
        composeFuture.join();

        // thenCombine
        CompletableFuture<String> combineFuture = future.thenCombine(CompletableFuture.supplyAsync(() -> "10"), (s1, s2) -> "Combine result is: " + s1 + " - " + s2);
        combineFuture.thenAccept(System.out::println);
        combineFuture.join();
    }
}
