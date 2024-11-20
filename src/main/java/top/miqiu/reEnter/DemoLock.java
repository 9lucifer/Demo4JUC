package top.miqiu.reEnter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.reEnter
 * @Project：Demo4JUC
 * @name：DemoLock
 * @Date：2024/11/20 4:44
 * @Filename：DemoLock
 * @Purpose：null
 */
public class DemoLock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        //创建线程
        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"外层");

                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"内层");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }finally {
                    lock.unlock();

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();

            }
        },"AA").start();

    }
}
