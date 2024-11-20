package top.miqiu.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.forkJoin
 * @Project：Demo4JUC
 * @name：forkJoinDemo
 * @Date：2024/11/20 14:59
 * @Filename：forkJoinDemo
 * @Purpose：null
 */
public class forkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Mytask mytask = new Mytask(0,100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(mytask);

        Integer res = forkJoinTask.get();
        System.out.println(res);
        forkJoinPool.shutdown();
    }
}

class Mytask extends RecursiveTask<Integer>{
    @Override
    protected Integer compute() {
        //判断俩数的插值

        if(end - begin<=value){
            //相加
            for (int i = begin; i <= end; i++) {
                res+=i;
            }

        }else {

            //拆分
            int middle = (begin+end) / 2;
            Mytask mytask1 = new Mytask(begin,middle);
            Mytask mytask2 = new Mytask(middle+1,end);
            mytask1.fork();
            mytask2.fork();

            res = mytask1.join()+ mytask2.join();

        }
        return res;
    }

    //拆分的插值不能超过10
    private static final Integer value = 10;

    private int begin;
    private int end;
    private int res;

    public Mytask(int begin,int end){
        this.begin = begin;
        this.end = end;
    }

}
