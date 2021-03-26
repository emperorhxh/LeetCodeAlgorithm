package com.xhx.common.algorithm.pattern;

import com.xhx.common.algorithm.pattern.ext.*;

import java.util.stream.Stream;

/**
 * 工厂模式
 *
 */
public class CarFactory implements FactoryMethod {
    @Override
    public Car create(String type) {
        switch(type) {
            case "baoma": return new BaomaCar();
            case "aodi": return new AodiCar();
            default: throw new RuntimeException(type);
        }
    }

    public static void main(String[] args) {
        CarFactory factory=new CarFactory();
        Stream.of("baoma", "aodi")
                .map(factory::create)
                .count(); // Terminal operation
    }
}
