package com.bao.core_java.jdk21;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringTemplate {
    void main() {
        String firstName = "B***";
        String lastName = "Ng****";

        String fullName =  STR."Full name: \{firstName} \{lastName}";
        log.info(fullName);
    }
}
