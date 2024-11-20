package top.miqiu.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.pool
 * @Project：Demo4JUC
 * @name：ThreadPoolDemo
 * @Date：2024/11/20 14:28
 * @Filename：ThreadPoolDemo
 * @Purpose：null
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {

        //一池n线程
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);

        //一池一线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();

        //可扩容线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        try {
            for (int i = 1; i <= 10; i++) {
                threadPool3.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"正在办理业务");
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadPool3.shutdown();
        }

    }
}
