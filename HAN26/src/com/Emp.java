package com;

/**
 * Author:Fanleilei
 * Created:2019/3/28 0028
 */
public class Emp {

    private String ename;
    private String job;
    private Integer age;


    public String getEname() {
        return ename;
    }

    public String getJob() {
        return job;
    }

    public Integer getAge() {
        return age;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                '}';
    }
}
