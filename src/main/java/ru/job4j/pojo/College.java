package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setStudent("Dolgov Konstantin Aleksandrovich");
        student.setGroup("4A51");
        student.setAdmission(new Date());
        System.out.println(student.getStudent() + "\n" + student.getGroup() + "\n" + student.getAdmission());
    }
}
