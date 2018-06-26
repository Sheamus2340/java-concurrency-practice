package com.designmodel.builder;

/**
 * Created by Sheamus on 2018/6/26.
 */
public class Student2 {
    private int id;
    private String name;
    private String passwd;
    private String sex;
    private String address;

    public static Student2 newStudent(Builder builder) {
        Student2 student = new Student2();
        student.id = builder.id;
        student.name = builder.name;
        student.passwd = builder.passwd;
        student.sex = builder.sex;
        student.address = builder.address;
        return student;
    }

    @Override
    public String toString() {

        return name + "的ID是：" + id + "密码是：" + passwd + "性别是：" + sex + "住在：" + address;
    }

    public static class Builder {
        private int id;
        private String name;
        private String passwd;
        private String sex;
        private String address;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder passwd(String passwd) {
            this.passwd = passwd;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Student2 build() {
            return newStudent(this);
        }

    }
}
