package com.bao.core_java.marker_annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
public class BMain {
    void main() {
        try {
            Method methodA = BService.class.getMethod("doA");
            Retryable cacheA = methodA.getAnnotation(Retryable.class);
            log.info("Method A - cache timeout: {}", cacheA.timeout());

            Method methodB = BService.class.getMethod("doB");
            Retryable cacheB = methodB.getAnnotation(Retryable.class);
            log.info("Method B - cache timeout: {}", cacheB.timeout());
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}
