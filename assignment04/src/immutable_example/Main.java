package immutable_example;

import hashcode_equals_example.Student;

public class Main {
    public static void main(String[] args) {

        ImmutableStudent immutableStudent = new ImmutableStudent(19,new Name(new StringBuilder("Jenya")));
        System.out.println(immutableStudent.getAge());
        System.out.println(immutableStudent.getName().getStrName());

        ImmutableStudent immutableStudent2 = new ImmutableStudent(20,new Name(immutableStudent.getName().getStrName()));
        immutableStudent2.getName().getStrName().append("log");

        System.out.println(immutableStudent.getAge());
        System.out.println(immutableStudent.getName().getStrName());




    }
}
