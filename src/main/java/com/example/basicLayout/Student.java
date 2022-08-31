package com.example.basicLayout;

public class Student extends User{
    private int id;
    private String name;
    private String classnum;
    private String school;
    private String account;
    private String password;
    private int res;

    public Student(){
        super(1);
    }


    public Student(int id, String name, String classnum, String school, String account, String password) {
        super(1);
        this.id = id;
        this.name = name;
        this.classnum = classnum;
        this.school = school;
        this.account = account;
        this.password = password;
    }

    public Student(int id, String name, String classnum,int res){
        this.id = id;
        this.name = name;
        this.classnum = classnum;
        this.res = res;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRes() { return res; }

    public void setRes(int res) { this.res = res; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classnum='" + classnum + '\'' +
                ", school='" + school + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ",result='" + res + '\'' +
                '}';
    }
}
