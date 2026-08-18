package com.bao.core_java.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;

@Slf4j
public class Sorting {
    @Data
    @AllArgsConstructor
    class Account {
        private String name;
        private int balance;
    }

    void main() {

        List<Account> accounts = List.of(new Account("A1", 10), new Account("A4", 5), new Account("A3", 30), new Account("A2", 5));

        List<Account> sortedAccounts = accounts.stream().sorted(Comparator.comparing(Account::getBalance).thenComparing(Account::getName)).toList();
        log.info("Result 1: {}", sortedAccounts);

        Function<Account, String> byName = Account::getName;
        Function<Account, Integer> byBalance = Account::getBalance;

        List<Account> sortedAccounts2 = accounts.stream().sorted(Comparator.comparing(byBalance).thenComparing(byName)).toList();
        log.info("Result 2: {}", sortedAccounts2);

        Integer[] array = {5,1,9,2};
        Arrays.sort(array, Comparator.reverseOrder());
        log.info("After sorting 1: {}", Arrays.toString(array));

        int[] a = {5,1,9,2};
        Integer[] b = Arrays.stream(a).boxed().toList().toArray(Integer[]::new);
        Arrays.sort(b, Comparator.reverseOrder());
        log.info("After sorting 2: {}", Arrays.toString(b));

        int[] bb = Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        log.info("After sorting 3: {}", bb);

    }
}
