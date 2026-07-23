package com.bao.core_java.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class FlatMap {

    void main() {
        List<List<Integer>> numbers = List.of(List.of(1, 2), List.of(3, 4));

        List<Integer> result = numbers.stream().flatMap(List::stream).toList();

        log.info("FlatMap Result: {}", result);
    }
}
