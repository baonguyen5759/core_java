package com.bao.core_java.optional;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class SimpleOptional {

    void main() {
        String name = null;
        String name2 = "Hi";
        String value = Optional.ofNullable(name).orElse("It's null");
        String value2 = Optional.ofNullable(name2).orElse("It's null");
        log.info("Nullable result: value: {}, value2: {}", value, value2);
    }
}
