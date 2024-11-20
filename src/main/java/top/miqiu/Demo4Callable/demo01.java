package top.miqiu.Demo4Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.Demo4Callable
 * @Project：Demo4JUC
 * @name：demo01
 * @Date：2024/11/20 5:57
 * @Filename：demo01
 * @Purpose：null
 */
public class demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new MyThread1(),"aa").start();


        //futureTask的使用
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());

        //lam表达式
        FutureTask<Integer> futureTask1 = new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+" come into callable");
            return 1024;
        });

        new Thread(futureTask1,"lucy").start();
        System.out.println(futureTask1.get());
    }

}

class  MyThread1 implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable{

    @Override
    public Object call() throws Exception {
        return 200;
    }
}
