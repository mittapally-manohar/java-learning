package org.consistent.practice.assessment.icims;

public class B extends A{
    public void display() {
        System.out.println("Class B");
    }

    public static void m(){
        System.out.println("class b static");
    }

    public void m1(){
        System.out.println("class b m1");
    }

    public static void main(String[] args) {
        A a = new B();
        a.display();
        A.m();
        ((B) a).m1();
    }
}
