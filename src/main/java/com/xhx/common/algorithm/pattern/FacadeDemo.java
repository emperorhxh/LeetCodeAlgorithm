package com.xhx.common.algorithm.pattern;

/**
 * 外观模式
 */
public class FacadeDemo {
    static A makeA(int x) { return new A(x); }
    static B makeB(long x) { return new B(x); }
    static C makeC(double x) { return new C(x); }
    public static void main(String[] args) {
        // The client programmer gets the objects
        // by calling the static methods:
        A a = FacadeDemo.makeA(1);
        B b = FacadeDemo.makeB(1);
        C c = FacadeDemo.makeC(1.0);
    }
}
class A { A(int x) {} }

class B { B(long x) {} }

class C { C(double x) {} }