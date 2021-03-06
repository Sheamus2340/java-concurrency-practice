package com.jdk8.level01.deepcopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * 1. 让每个引用类型属性内部都重写clone() 方法;
 * 2. 利用序列化;
 * Created by Sheamus on 2018/6/21.
 */
public class Person implements Cloneable {
    public String pname;
    public int page;
    public Address address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.address = (Address) address.clone();
        return p;
    }

    public void display(String name) {
        System.out.println(name + ":" + "pname=" + pname + ", page=" + page + "," + address);
    }

    public Person() {}

    public Person(String pname,int page){
        this.pname = pname;
        this.page = page;
        this.address = new Address();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(String provices, String city) {
        this.address.setAddress(provices,city);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person("zhangsan", 21);
        p1.setAddress("湖北省", "武汉市");
        Person p2 = (Person) p1.clone();

        System.out.println("p1:" + p1);
        System.out.println("p1.getPname:" + p1.getPname().hashCode());
        System.out.println("p1.getAddress:" + p1.getAddress().hashCode());

        System.out.println("p2:" + p2);
        System.out.println("p2.getPname:" + p2.getPname().hashCode());
        System.out.println("p2.getAddress:" + p2.getAddress().hashCode());

        p1.display("p1");
        p2.display("p2");

        p2.setAddress("湖男省", "荆州市");
        p1.setAddress("湖省", "荆市");
        p1.setPage(44);
        System.out.println("将复制之后的对象地址修改：");

        p1.display("p1");
        p2.display("p2");
    }

    //深度拷贝
    public Object deepClone() throws Exception{
        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(this);

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

}
