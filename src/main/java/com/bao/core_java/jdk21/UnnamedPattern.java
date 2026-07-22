package com.bao.core_java.jdk21;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class UnnamedPattern {
    void main() {
        for(String _: List.of("A", "B", "C")) {
            log.info("Hello...");
        }
    }
}
