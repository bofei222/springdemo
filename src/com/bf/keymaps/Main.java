package com.bf.keymaps;

/**
 * @author bofei
 * @date 2018/9/19 9:38
 */


class C {
    void eat() {
        System.out.println("c eat...");
    }
}
class A extends C{
    @Override
    void eat() { // ctrl + u 好用...
        System.out.println("c eat...");
    }
}

class B extends A {
    @Override
    void eat() {
        System.out.println("b eat...");
    }
}
public class Main {
    public static void main(String[] args) {
        A a = new B();
        a.eat(); // ctrl + u 不好使...
    }
}
