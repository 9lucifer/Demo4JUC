package top.miqiu.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.juc
 * @Project：Demo4JUC
 * @name：countDownLaunchDemo
 * @Date：2024/11/20 11:13
 * @Filename：countDownLaunchDemo
 * @Purpose：null
 */
public class countDownLaunchDemo {
    //6个同学离开教室后才能离开教室



    public static void main(String[] args) throws InterruptedException {
        //创建对象，输入初始值
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"号同学走人");

                //计数
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"班长锁门走人");

    }
}
