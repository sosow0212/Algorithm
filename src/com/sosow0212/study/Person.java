package com.sosow0212.study;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addAge(int age) {
        this.age += age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
