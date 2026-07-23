package com.bao.core_java.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MapReduce {
    void main() {
        @Data
        @AllArgsConstructor
        class Account {
            private String name;
            private int balance;
        }

        List<Account> accounts = List.of(new Account("A1", 10), new Account("A4", 5), new Account("A3", 30), new Account("A2", 5));

        long sum = accounts.stream().mapToInt(Account::getBalance).sum();
        long sum2 = accounts.stream().map(Account::getBalance).reduce(0, (x, y) -> x + y);
        log.info("Sum: {}, sum2: {}", sum, sum2);
    }
}
