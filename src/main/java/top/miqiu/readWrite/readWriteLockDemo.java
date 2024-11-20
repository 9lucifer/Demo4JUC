package top.miqiu.readWrite;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.readWrite
 * @Project：Demo4JUC
 * @name：readWriteLockDemo
 * @Date：2024/11/20 11:49
 * @Filename：readWriteLockDemo
 * @Purpose：null
 */
public class readWriteLockDemo {

    public static void main(String[] args) {
        cache cache = new cache();

        for (int i = 0; i < 5; i++) {
            final  int num = i;
            new Thread(()->{
                cache.put(num+"",num+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final  int num = i;
            new Thread(()->{
                cache.get(num+"");
            },String.valueOf(i)).start();
        }
    }
}

class  cache{
    //创建读写锁
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();



    private volatile Map<String, Object>map = new HashMap<>();

    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+" 正在写操作"+key);
        try {
            TimeUnit.MICROSECONDS.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+" 已经写完"+key);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public Object get(String key){
        readWriteLock.writeLock().lock();

        Object res = null;
        try {
            res = null;
            System.out.println(Thread.currentThread().getName()+" 正在读取操作"+key);
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            res = map.get(key);
            System.out.println(Thread.currentThread().getName()+" 已经取完了"+key);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.writeLock().unlock();
        }
        return res;
    }
}
