package com.rain.juc.unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Test
 * @Author Rain
 * @Date 2024/10/1 17:24
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        final ThreadUnsafeExample example = new ThreadUnsafeExample();
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.submit(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.getNum());
    }
}
