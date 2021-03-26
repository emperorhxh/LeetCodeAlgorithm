package com.xhx.common.algorithm.pattern.ext;

public class Square extends Shape {
    private int x, y, radius;

    public Square(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
