package com.bao.core_java.marker_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * There are 3 types of Retention: SOURCE, CLASS and RUNTIME
 * - SOURCE:
 *      - existed only in .java source code
 *      - Remove during compilation
 *      - Not present in .class files
 *      - Cannot be accessed via reflection
 *      - Used for:
 *          + Code analysis tool
 *          + Static checking
 *          + IDE Hints
 * - CLASS
 *      - Stored in .class file
 *      - Not available at runtime
 *      - JVM cannot read it through reflection
 * - RUNTIME:
 *      - Stored in .class file
 *      - Available while running
 *      - Can be read using Reflection
 *      - Java Spring is heavily using this type of Retention like @Transaction
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Retryable {
    int timeout();
}
