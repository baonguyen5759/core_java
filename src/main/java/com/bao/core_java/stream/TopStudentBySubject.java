package com.bao.core_java.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class TopStudentBySubject {

    @Data
    @AllArgsConstructor
    class Student {
        private String studentName;
        private String subject;
        private int score;
    }

    void main() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("AA", "Math", 90));
        students.add(new Student("BB", "Math", 85));
        students.add(new Student("CC", "Math", 70));
        students.add(new Student("DD", "Physics", 95));
        students.add(new Student("EE", "Physics", 80));
        students.add(new Student("FF", "Physics", 98));

        // Method 1
        Map<String, List<Student>> mapStudentBySubject = students.stream().collect(Collectors.groupingBy(Student::getSubject));
        mapStudentBySubject.entrySet().forEach(x -> {
            Optional<Student> optStudent = x.getValue().stream().max(Comparator.comparingInt(Student::getScore));
            if (optStudent.isPresent()) {
                log.info("Method 1: Subject: {} | Student: {} | Score: {}", x.getKey(), optStudent.get().getStudentName(), optStudent.get().getScore());
            }
        });

        // Method 2:
        Map<String, Student> mapTopStudent = students.stream().collect(Collectors.groupingBy(Student::getSubject, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Student::getScore)), Optional::get)));
        mapTopStudent.entrySet().forEach(x -> {
            log.info("Method 2: Subject: {} | Student: {} | Score: {}", x.getKey(), x.getValue().getStudentName(), x.getValue().getScore());
        });

        // Method 3:
        Map<String, Student> mapTopStudent2 = students.stream().collect(Collectors.toMap(Student::getSubject, s -> s, (s1, s2) -> s1.getScore() > s2.getScore()? s1 : s2));
        mapTopStudent2.entrySet().forEach(x -> {
            log.info("Method 3: Subject: {} | Student: {} | Score: {}", x.getKey(), x.getValue().getStudentName(), x.getValue().getScore());
        });
    }
}
