package com.bao.core_java.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class TopStudentBySubject {
    /*
    @Data
    @AllArgsConstructor
    class Student {
        private String studentName;
        private String subject;
        private int score;
    }*/

    record Student (String studentName, String subject, int score) {};

    void main() {

        List<Student> students = new ArrayList<>();

        students.add(new Student("AA", "Math", 90));
        students.add(new Student("BB", "Math", 85));
        students.add(new Student("CC", "Math", 70));
        students.add(new Student("DD", "Physics", 95));
        students.add(new Student("EE", "Physics", 80));
        students.add(new Student("FF", "Physics", 98));

        // Method 1
        Map<String, List<Student>> mapStudentBySubject = students.stream().collect(Collectors.groupingBy(Student::subject));
        mapStudentBySubject.entrySet().forEach(x -> {
            Optional<Student> optStudent = x.getValue().stream().max(Comparator.comparingInt(Student::score));
            if (optStudent.isPresent()) {
                log.info("Method 1: Subject: {} | Student: {} | Score: {}", x.getKey(), optStudent.get().studentName(), optStudent.get().score());
            }
        });

        // Method 2:
        Map<String, Student> mapTopStudent = students.stream().collect(Collectors.groupingBy(Student::subject, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Student::score)), Optional::get)));
        mapTopStudent.entrySet().forEach(x -> {
            log.info("Method 2: Subject: {} | Student: {} | Score: {}", x.getKey(), x.getValue().studentName(), x.getValue().score());
        });

        // Method 3:
        Map<String, Student> mapTopStudent2 = students.stream().collect(Collectors.toMap(Student::subject, s -> s, (s1, s2) -> s1.score() > s2.score()? s1 : s2));
        mapTopStudent2.entrySet().forEach(x -> {
            log.info("Method 3: Subject: {} | Student: {} | Score: {}", x.getKey(), x.getValue().studentName(), x.getValue().score());
        });
    }
}
