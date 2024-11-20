package top.miqiu;

/**
 * @Author：丁浩然
 * @Package：top.miqiu
 * @Project：Demo4JUC
 * @name：thread2types
 * @Date：2024/11/20 1:13
 * @Filename：thread2types
 * @Purpose：用户线程和守护线程
 */
public class thread2types {

    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            //默认结果是false，说明是用户线程
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {
            }
        }, "aa");
        aa.setDaemon(true);//如果设置成了守护线程就会结束
        aa.start();
        System.out.println(Thread.currentThread().getName()+":over");
    }



}
