package com.xiangxue.ch1.syn;

/**
 * @author xuzehua
 * @data 2019/10/31 16:35
 * @desc
 */
public class  AccountingSync implements Runnable{
    //共享资源(临界资源)
    static int i=0;
    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase(){
        i++;
    }
    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increase();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        AccountingSync instance=new AccountingSync();
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
        /**
         * 输出结果:
         * 2000000
         */


//
//    public static void main(String[] args) throws InterruptedException {
//
//        //new新实例
//        Thread t1=new Thread(new AccountingSync());
//        //new新实例
//        Thread t2=new Thread(new AccountingSync());
//        t1.start();
//        t2.start();
//        //join含义:当前线程A等待thread线程终止之后才能从thread.join()返回
//        t1.join();
//        t2.join();
//        System.out.println(i);


