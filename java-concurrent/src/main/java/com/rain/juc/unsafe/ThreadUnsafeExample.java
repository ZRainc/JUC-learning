package com.rain.juc.unsafe;

/**
 * @ClassName ThreadUnsafeExample
 * @Author Rain
 * @Date 2024/10/1 17:23
 * @Version 1.0
 */
public class ThreadUnsafeExample {

    private int num = 0;

    public int getNum() {
        return num;
    }

    public void add() {
        num++;
    }
}
