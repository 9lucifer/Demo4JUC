package top.miqiu;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author：丁浩然
 * @Package：top.miqiu
 * @Project：Demo4JUC
 * @name：completableFutureDemo
 * @Date：2024/11/20 15:12
 * @Filename：completableFutureDemo
 * @Purpose：null
 */
public class completableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //异步调用，有返回值
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"com2");
            return 200;
        });

        completableFuture1.whenComplete((t,u)->{
            System.out.println(t);
            System.out.println(u);
        });

        completableFuture1.get();


//        //异步调用，无返回值
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName()+"com1");
//        });
//
//        completableFuture.get();
    }
}
