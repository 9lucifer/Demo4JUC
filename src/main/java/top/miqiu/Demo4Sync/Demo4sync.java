package top.miqiu.Demo4Sync;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：丁浩然
 * @Package：top.miqiu
 * @Project：Demo4JUC
 * @name：synchDemo
 * @Date：2024/11/20 1:21
 * @Filename：synchDemo
 * @Purpose：使用syn关键字
 */
public class Demo4sync {
    //三个售票员，最终是卖出30张票

    public static void main(String[] args) {
        //创建ticket对象
        ticket ticket = new ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //调用卖票
                for (int i = 0; i < 10; i++) {
                    ticket.sale();
                }

            }
        },"AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //调用卖票
                for (int i = 0; i < 30; i++) {
                    ticket.sale();
                }
            }
        },"CC").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //调用卖票
                ticket.sale();
            }
        },"BB").start();
    };


}
@Data
@AllArgsConstructor
@NoArgsConstructor
class ticket {
    //票数
    private int number = 30;

    //卖票
    public synchronized void sale(){
        //判断票的数量是否是小于0
        if(number>0){
            number--;
            System.out.println(Thread.currentThread().getName()+" :剩下"+number);
        }

    }


}
