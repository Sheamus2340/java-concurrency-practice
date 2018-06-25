package com.jdk8.level01.shallowcopy;

/**
 * Created by Sheamus on 2018/6/21.
 */
public class Person implements Cloneable {
    public String pname;
    public int page;
    public Address address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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

}
