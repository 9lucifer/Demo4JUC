package top.miqiu.Demo4Sync;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.Demo4Sync
 * @Project：Demo4JUC
 * @name：ThreadDemo1
 * @Date：2024/11/20 2:05
 * @Filename：ThreadDemo1
 * @Purpose：null
 */


public class ThreadDemo1 {
    public static void main(String[] args) {
        share share = new share();
        //创建多线程进行调用
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.increament();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"aa").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decreament();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"bb").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.increament();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"cc").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decreament();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"dd").start();
    }


}

class share {
    int number = 0;

    //+1
    public synchronized void increament() throws InterruptedException {
        //判断
        while(number!=0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread()+" :: "+number);
        this.notifyAll();//通知其他的线程

    }
    //-1
    public synchronized void decreament() throws InterruptedException {
        //判断
        while(number!=1){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread()+" :: "+number);
        this.notifyAll();//通知其他的线程

    }
}