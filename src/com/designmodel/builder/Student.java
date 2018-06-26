package com.designmodel.builder;

/**
 * Builder设计模式
 * Created by Sheamus on 2018/6/26.
 */
public class Student {
    private int id;
    private String name;
    private String passwd;
    private String sex;
    private String address;

    @Override
    public String toString() {

        return name + "的ID是：" + id + "密码是：" + passwd + "性别是：" + sex + "住在：" + address;
    }

    public static class Builder {

        private Student target;

        public Builder() {
            target = new Student();
        }

        public Builder id(int id) {
            target.id = id;
            return this;
        }

        public Builder name(String name) {
            target.name = name;
            return this;
        }

        public Builder passwd(String passwd) {
            target.passwd = passwd;
            return this;
        }

        public Builder sex(String sex) {
            target.sex = sex;
            return this;
        }

        public Builder address(String address) {
            target.address = address;
            return this;
        }

        public Student build(){
            return target;
        }

    }

}
