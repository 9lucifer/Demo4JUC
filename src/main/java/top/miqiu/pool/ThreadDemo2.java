package top.miqiu.pool;

import lombok.val;

import java.util.concurrent.*;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.pool
 * @Project：Demo4JUC
 * @name：ThreadDemo2
 * @Date：2024/11/20 14:51
 * @Filename：ThreadDemo2
 * @Purpose：null
 */
public class ThreadDemo2 {

    public static void main(String[] args) {
       ExecutorService threadPool1 = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        try {
            for (int i = 1; i <= 10; i++) {
                threadPool1.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"正在办理业务");
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadPool1.shutdown();
        }
    }
}
