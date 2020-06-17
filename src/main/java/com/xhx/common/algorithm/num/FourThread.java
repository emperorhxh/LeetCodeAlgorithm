package com.xhx.common.algorithm.num;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Function: 4个线程交替执行打印 abcd
 */
public class FourThread {
    private int start = 1;

    /**
     * 对 flag 的写入虽然加锁保证了线程安全，但读取的时候由于 不是 volatile 所以可能会读取到旧值
     *
     */
    private volatile int current = 1;

    /**
     * 重入锁
     */
    private final static Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        FourThread twoThread = new FourThread();

        Thread t1 = new Thread(new MyCounter(twoThread,1));
        t1.setName("t1");

        Thread t2 = new Thread(new MyCounter(twoThread,2));
        t2.setName("t2");

        Thread t3 = new Thread(new MyCounter(twoThread,3));
        t3.setName("t3");

        Thread t4 = new Thread(new MyCounter(twoThread,4));
        t4.setName("t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    /**
     * 偶数线程
     */
    public static class MyCounter implements Runnable {

        private FourThread number;
        private int matchNum;

        public MyCounter(FourThread number,int matchNum) {
            this.number = number;
            this.matchNum=matchNum;
        }

        @Override
        public void run() {
            while (number.start <= 1000) {

                if (this.matchNum == number.current) {
                    try {
                        //LOCK.lock();
                        char a = (char) ('a'+(matchNum-1));
                        System.out.println(Thread.currentThread().getName() + "==>" + a);
                        number.start++;
                        if(this.matchNum ==1 ){
                            number.current =2;
                        }
                        if(this.matchNum ==2 ){
                            number.current =3;
                        }
                        if(this.matchNum ==3 ){
                            number.current =4;
                        }
                        if(this.matchNum ==4 ){
                            number.current =1;
                        }

                    } finally {
                        //LOCK.unlock();
                    }
                }
            }
        }
    }

}
