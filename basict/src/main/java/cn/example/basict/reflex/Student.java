package cn.example.basict.reflex;

/**
 * Author：created by SugarT
 * Time：2019/12/4 21
 */
public  class Student {


    private String name;

    private String age;

    private Student(String name) {
        this.name = name;
    }

    private Student(String name, String age) {
        this.name = name;
        this.age = age;
    }


    private void printName() {

        System.out.println("Student name" + name);
    }

    private void printAge() {
        System.out.println("Student age" + age);
    }


    private void print(String str) {

        System.out.println("Student name" + str);
    }
}
