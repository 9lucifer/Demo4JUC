package top.miqiu.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.juc
 * @Project：Demo4JUC
 * @name：cyclicBarrierDemo
 * @Date：2024/11/20 11:19
 * @Filename：cyclicBarrierDemo
 * @Purpose：null
 */
public class cyclicBarrierDemo {
    //创建固定值
    public static final int number = 7;
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier =
                new CyclicBarrier(number,()->{
                    System.out.println("召唤神龙");
                });

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"星龙珠");

                //等待
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            },String.valueOf(i)).start();
        }


    }
}
