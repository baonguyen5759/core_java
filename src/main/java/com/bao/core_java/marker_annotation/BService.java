package com.bao.core_java.marker_annotation;

public class BService {
    @Retryable(timeout = 30)
    public void doA() {
    }

    @Retryable(timeout = 60)
    public void doB() {
    }
}
