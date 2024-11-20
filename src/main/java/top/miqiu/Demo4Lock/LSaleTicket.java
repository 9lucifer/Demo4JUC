package top.miqiu.Demo4Lock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.Demo4Lock
 * @Project：Demo4JUC
 * @name：LSaleTicket
 * @Date：2024/11/20 1:38
 * @Filename：LSaleTicket
 * @Purpose：null
 */

public class LSaleTicket {

    public static void main(String[] args) {
        ticket ticket = new ticket();

        new Thread(()->{
            for (int i = 0; i < 13; i++) {
                ticket.sale();
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 13; i++) {
                ticket.sale();
            }
        },"BB").start();

        new Thread(()->{
            for (int i = 0; i < 13; i++) {
                ticket.sale();
            }
        },"CC").start();
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class ticket {
    //票数
    private int number = 30;

    public  final ReentrantLock lock = new ReentrantLock();

    //卖票
    public  void sale(){
        //上锁
        lock.lock();

        try {
            //判断票的数量是否是小于0
            if(number>0){
                number--;
                System.out.println(Thread.currentThread().getName()+" :剩下"+number);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //解锁
            lock.unlock();
        }

    }


}

