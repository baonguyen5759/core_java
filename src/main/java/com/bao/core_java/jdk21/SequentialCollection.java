package com.bao.core_java.jdk21;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SequentialCollection {
    void main() {
        List<String> emps = new ArrayList<>();
        emps.add("B*** Ng****");
        emps.add("J*** R*****");
        log.info("Last employee: {}", emps.getLast());
    }
}
