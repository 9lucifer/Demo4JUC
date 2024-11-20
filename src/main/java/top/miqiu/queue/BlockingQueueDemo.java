package top.miqiu.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.queue
 * @Project：Demo4JUC
 * @name：BlockingQueueDemo
 * @Date：2024/11/20 14:02
 * @Filename：BlockingQueueDemo
 * @Purpose：null
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        //创建阻塞队列
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //第一组方法
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("a"));
        //加多了报错


        //第二组方法
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

        //第三组方法
//        blockingQueue.put("a");
//        blockingQueue.put("a");
//        blockingQueue.put("a");
////        blockingQueue.put("a");
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());

        //第四组
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a",3L, TimeUnit.SECONDS));

    }
}
