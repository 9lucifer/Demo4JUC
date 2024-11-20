package top.miqiu.collectionsDemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author：丁浩然
 * @Package：top.miqiu
 * @Project：Demo4JUC
 * @name：ThreadCollectionDEmo
 * @Date：2024/11/20 3:09
 * @Filename：ThreadCollectionDEmo
 * @Purpose：null
 */
public class ThreadCollectionDEmo {
    public static void main(String[] args) {
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        List<String>list = new CopyOnWriteArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                //向集合里面添加内容
//                list.add(UUID.randomUUID().toString().substring(0,8));
//                //从集合获取内容
//                System.out.println(list);
//            },String.valueOf(i)).start();
//        }
        //arraylist
//        Exception in thread "2" Exception in thread "1" Exception in thread "6" java.util.ConcurrentModificationException
//        at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
//        at java.util.ArrayList$Itr.next(ArrayList.java:859)
//        at java.util.AbstractCollection.toString(AbstractCollection.java:461)
//        at java.lang.String.valueOf(String.java:2994)
//        at java.io.PrintStream.println(PrintStream.java:821)
//        at top.miqiu.collectionsDemo.ThreadCollectionDEmo.lambda$main$0(ThreadCollectionDEmo.java:25)
//        at java.lang.Thread.run(Thread.java:748)
//        java.util.ConcurrentModificationException
//        at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
//        at java.util.ArrayList$Itr.next(ArrayList.java:859)
//        at java.util.AbstractCollection.toString(AbstractCollection.java:461)
//        at java.lang.String.valueOf(String.java:2994)
//        at java.io.PrintStream.println(PrintStream.java:821)
//        at top.miqiu.collectionsDemo.ThreadCollectionDEmo.lambda$main$0(ThreadCollectionDEmo.java:25)
//        at java.lang.Thread.run(Thread.java:748)
//        java.util.ConcurrentModificationException
//        at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
//        at java.util.ArrayList$Itr.next(ArrayList.java:859)
//        at java.util.AbstractCollection.toString(AbstractCollection.java:461)
//        at java.lang.String.valueOf(String.java:2994)
//        at java.io.PrintStream.println(PrintStream.java:821)
//        at top.miqiu.collectionsDemo.ThreadCollectionDEmo.lambda$main$0(ThreadCollectionDEmo.java:25)
//        at java.lang.Thread.run(Thread.java:748)

        //vector是可以的
        //Collections.synchronizedList(new ArrayList<>()) 也可以
//       Set<String>list = new CopyOnWriteArraySet<>();
//        for (int i = 0; i < 100; i++) {
//            new Thread(()->{
//                //向集合里面添加内容
//                list.add(UUID.randomUUID().toString().substring(0,8));
//                //从集合获取内容
//                System.out.println(list);
//            },String.valueOf(i)).start();
//        }
        Map<String,String>list = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            String key = String.valueOf(i);

            new Thread(()->{
                //向集合里面添加内容
                list.put(key,UUID.randomUUID().toString().substring(0,8));
                //从集合获取内容
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}
