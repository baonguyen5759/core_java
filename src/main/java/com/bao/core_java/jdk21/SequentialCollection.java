package com.bao.core_java.jdk21;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@Slf4j
public class SequentialCollection {
    void main() {
        List<String> emps = new ArrayList<>();
        emps.add("B*** Ng****");
        emps.add("J*** R*****");
        log.info("Last employee: {}", emps.getLast());

        Deque<String> deque = new ArrayDeque<>();
        deque.add("JDK 17");
        deque.add("JDK 21");
        log.info("Front: {} | Back: {}", deque.getFirst(), deque.getLast());
    }
}
