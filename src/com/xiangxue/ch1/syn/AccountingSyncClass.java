package com.xiangxue.ch1.syn;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author xuzehua
 * @data 2019/10/31 16:52
 * @desc
 */
public class AccountingSyncClass implements Runnable{
    static int i=0;

    /**
     * 作用于静态方法,锁是当前class对象,也就是
     * AccountingSyncClass类对应的class对象
     */
    public static synchronized void increase(){
        i++;
    }

    /**
     * 非静态,访问时锁不一样不会发生互斥
     */
    public synchronized void increase4Obj(){
        i++;
    }

    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increase();
        }
    }
//    public static void main(String[] args) throws InterruptedException {
//        //new新实例
//        Thread t1=new Thread(new AccountingSyncClass());
//        //new新实例
//        Thread t2=new Thread(new AccountingSyncClass());
//        //启动线程
//        t1.start();t2.start();
//
//        t1.join();t2.join();
//        System.out.println(i);
//    }
//    public static void main(String[] args) {
//        String nextMonth= "";
//        SimpleDateFormat sdf = new SimpleDateFormat("MM");
//        Calendar calendar = Calendar.getInstance();
//        //获取下个月的年份月份
//        calendar.add(Calendar.MONTH, 1);
//        nextMonth = sdf.format(calendar.getTime());
//        System.out.println("增加后的年份："+calendar.get(Calendar.YEAR));
//        System.out.println("增加后的月份："+nextMonth);
//        String newt=calendar.get(Calendar.YEAR)+nextMonth;
//    }

    public static void main(String[] args) {
        time1();
        System.out.println("记时结束");
    }
    private static void time1() {
        int time = 10;
        while (time > 0) {
            time--;
            try {
                Thread.sleep(1000);
//                int hh = time / 60 / 60 % 60;
//                int mm = time / 60 % 60;
//                int ss = time % 60;
//                System.out.println( ss + "秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

