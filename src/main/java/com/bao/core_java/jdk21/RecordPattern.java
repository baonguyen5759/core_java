package com.bao.core_java.jdk21;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecordPattern {
    record Name (String firstName, String lastName) {}

    private static void printName(Object obj) {
        if (obj instanceof Name(String first, String last)) {
            log.info("First Name: {} | Last Name: {}", first, last);
        }
    }

    void main() {
        Name name = new Name("B**", "Ng****");
        printName(name);
    }
}
