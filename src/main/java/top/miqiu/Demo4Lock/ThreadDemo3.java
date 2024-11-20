package top.miqiu.Demo4Lock;

import com.sun.javaws.jnl.IconDesc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.Demo4Lock
 * @Project：Demo4JUC
 * @name：ThreadDemo3
 * @Date：2024/11/20 2:32
 * @Filename：ThreadDemo3
 * @Purpose：null
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        shareRes shareRes = new shareRes();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                shareRes.print5(i);
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                shareRes.print10(i);
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                shareRes.print15(i);
            }
        },"CC").start();
    }

}
class shareRes{
    //定义标志位
    private int flag = 1;//1 AA ；2BB ；3CC

    private Lock lock = new ReentrantLock();


    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    //打印5次
    public void print5(int loop) {
        lock.lock();
        try {
            while (flag!=1) {
                //等待
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" :: "+i+" :轮数: "+loop);
            }
            //先修改标志位再通知
            flag = 2;
            c2.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }


    //打印10次
    public void print10(int loop) {
        lock.lock();
        try {
            while (flag!=2) {
                //等待
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+" :: "+i+" :轮数: "+loop);
            }
            //先修改标志位再通知
            flag = 3;
            c3.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void print15(int loop) {
        lock.lock();
        try {
            while (flag!=3) {
                //等待
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+" :: "+i+" :轮数: "+loop);
            }
            //先修改标志位再通知
            flag = 1;
            c1.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
