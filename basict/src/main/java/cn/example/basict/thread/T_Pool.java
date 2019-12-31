package cn.example.basict.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author：created by SugarT
 * Time：2019/10/31 17
 */
public class T_Pool {

    public static void main(String args[]) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {


                System.out.println("拒绝策略从新执行任务");
                new Thread(r).start();
            }
        });

        for (int i = 0; i < 20; i++) {

            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {

                    System.out.println(Thread.currentThread().getName());
                }
            });

        }


    }


}
