package com.itheima.jdbc;

public class Students {
    private Integer id;       // 学生id

    private String studentname; // 学生姓名

    private int age;  // 年龄

    private String score; //成绩

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student [ id=" + id + ", "
                + "studentname=" + studentname +
                ", age" + age +
                ", score=" + score +" ]";
    }
}
