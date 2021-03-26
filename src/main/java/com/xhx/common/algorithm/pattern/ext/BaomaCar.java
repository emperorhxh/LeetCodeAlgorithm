package com.xhx.common.algorithm.pattern.ext;

public class BaomaCar extends Car {
    public BaomaCar() {
        super("baoma");
    }

    @Override
    public void take() {
        System.out.println("take baoma");
    }
}
