package com.xhx.common.algorithm.num;

public class Point {

    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    /**
     * 点到点的距离（没有开根）
     * @param point
     * @return
     */
    public int dis(Point point){
        return (this.x-point.x)*(this.x-point.x) +(this.y-point.y)*(this.y-point.y);
    }
}
