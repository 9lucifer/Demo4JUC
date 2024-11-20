package top.miqiu.readWrite;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author：丁浩然
 * @Package：top.miqiu.readWrite
 * @Project：Demo4JUC
 * @name：Down
 * @Date：2024/11/20 12:09
 * @Filename：Down
 * @Purpose：null
 */
public class Down {

    public static void main(String[] args) {
        //可重入读写锁对象
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock= rwLock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();

        //锁降级
        writeLock.lock();
        System.out.println("lucifer");
        readLock.lock();
        System.out.println("read---");
        //释放写锁
        writeLock.unlock();
        //释放读锁
        readLock.unlock();

    }
}
