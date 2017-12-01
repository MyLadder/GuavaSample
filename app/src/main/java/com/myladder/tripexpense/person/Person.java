package com.myladder.tripexpense.person;

import com.google.common.base.MoreObjects;

/**
 * Created by Manu on 12/1/2017.
 */


public class Person {

    private int age;
    private String name;
    private Gender sex;

    public Person(int age, String name, Gender sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {

        return MoreObjects.toStringHelper(Person.class)
                .add("Age", age)
                .add("Name", name)
                .add("Sex", sex)
                .toString();
    }
}