package top.miqiu.Demo4Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.Demo4Lock
 * @Project：Demo4JUC
 * @name：ThreadDemo2
 * @Date：2024/11/20 2:20
 * @Filename：ThreadDemo2
 * @Purpose：null
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        share share = new share();
        //创建多线程进行调用
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share.incr();
            }
        },"aa").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share.decr();
            }
        },"bb").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share.incr();
            }
        },"cc").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share.decr();
            }
        },"dd").start();
    }

}

class share{
    private int number = 0;

    //创建lock
    private Lock lock = new ReentrantLock();
     private Condition condition =  lock.newCondition();

     //+1
     public void incr(){
         //上锁
         lock.lock();

         try {
             while (number!=0){
                 condition.await();
             }

             //干活
             number++;
             System.out.println(Thread.currentThread()+" :: "+number);
             condition.signalAll();

         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         } finally {
             //解锁
             lock.unlock();
         }


     }

     //-1
     public void decr(){
         //上锁
         lock.lock();

         try {
             while (number!=1){
                 condition.await();
             }

             //干活
             number--;
             System.out.println(Thread.currentThread()+" :: "+number);
             condition.signalAll();

         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         } finally {
             //解锁
             lock.unlock();
         }


     }

}
