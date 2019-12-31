package cn.example.basict.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author：created by SugarT
 * Time：2019/11/6 09
 */
public class LockThread {

    public static void main(String args[]) throws InterruptedException {


        //todo

//       final ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
//
//       for(int i=0;i<4;i++){
//
//           new Thread(new Runnable() {
//               @Override
//               public void run() {
//                   try {
//                       blockingQueue.put("哈哈"+Thread.currentThread().getName());
//                   } catch (InterruptedException e) {
//                       e.printStackTrace();
//                   }
//               }
//           }).start();
//
//
//
//       }
//
//
//       for(int i=0;i<4;i++){
//           new Thread(new Runnable() {
//               @Override
//               public void run() {
//                   try {
//                       System.out.println( blockingQueue.take());
//                   } catch (InterruptedException e) {
//                       e.printStackTrace();
//                   }
//               }
//           }).start();
//       }







        final BlockQueenLock<String> blockQueenLock = new BlockQueenLock<>(2);

        for(int i=0;i<4;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        blockQueenLock.put("哈哈"+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for(int i=0;i<4;i++){
           new Thread(new Runnable() {
               @Override
               public void run() {
                   try {
                       blockQueenLock.take();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }).start();
       }

    }


    /**
     * 模拟一个阻塞队列 ArrayBlockingQueue
     */
    static class BlockQueenLock<T> {

        private Object[] elements;

        private int head;

        private int footer;

        private int count;

        private ReentrantLock lock;

        private Condition notFull;

        private Condition notEmpty;

        public BlockQueenLock() {
            this(10);
        }

        public BlockQueenLock(int maxSize) {
            elements = new Object[maxSize];
            lock = new ReentrantLock();
            notFull = lock.newCondition();
            notEmpty = lock.newCondition();
        }


        private void put(T e) throws InterruptedException {

            lock.lock();
            try {
                if (count == getSize()) {
                    System.out.println("容器已满 开始等待...");
                    notFull.await();
                }
//                elements.add(footer,e);
                elements[footer] = e;

//                System.out.println("放入元素位置..."+footer +"  数据..."+e );
                if (++footer == getSize()) {
                    footer = 0;
                }
                ++count;
                notEmpty.signalAll();//唤醒
            } finally {
                lock.unlock();
            }
        }

        private T take() throws InterruptedException {

            lock.lock();
            try {
                if (count == 0) {
                    System.out.println("容器已空 开始等待....");
                    notEmpty.await();
                }
                T e = (T) elements[head];
                System.out.println("取出元素位置..."+head +"   数据..."+e);
                elements[head] = null;
                if (++head == getSize()) {
                    head = 0;
                }
                --count;
                notFull.signalAll();
                return e;
            } finally {
                lock.unlock();
            }
        }


        private int getSize() {
            return elements.length;
        }


    }


}
