package com.bao.core_java.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
public class Sorting {

    void main() {
        @Data
        @AllArgsConstructor
        class Account {
            private String name;
            private int balance;
        }

        List<Account> accounts = List.of(new Account("A1", 10), new Account("A4", 5), new Account("A3", 30), new Account("A2", 5));

        List<Account> sortedAccounts = accounts.stream().sorted(Comparator.comparing(Account::getBalance).thenComparing(Account::getName)).toList();
        log.info("Result 1: {}", sortedAccounts);

        Function<Account, String> byName = e -> e.getName();

        Function<Account, Integer> byBalance = Account::getBalance;
        List<Account> sortedAccounts2 = accounts.stream().sorted(Comparator.comparing(byBalance).thenComparing(byName)).toList();
        log.info("Result 2: {}", sortedAccounts2);
    }
}
