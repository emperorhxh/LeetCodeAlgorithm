package com.xhx.common.algorithm.pattern.ext;

public interface StateBase {
    void f();

    void g();

    void h();

    void changeImp(StateBase newImp);
}
