package com.bao.core_java.jdk21;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PatternMatching {
    static void formatObject(Object obj) {
        switch (obj) {
            case Integer i -> log.info("Integer: {}", i);
            case Long l -> log.info("Long: {}", l);
            case String s -> log.info("String: {}", s);
            default -> log.info("unsupported object.");
        }
    }

    void main() {
        formatObject(3);
        formatObject(5L);
        formatObject("Hello World !!!");
    }
}
