package top.miqiu.juc;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.juc
 * @Project：Demo4JUC
 * @name：SemaphoreDemo
 * @Date：2024/11/20 11:25
 * @Filename：SemaphoreDemo
 * @Purpose：null
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //创建，设置许可的数量
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+" 抢到了车位");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName()+" ；======离开了车位");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }


            },String.valueOf(i)).start();
        }
    }
}
