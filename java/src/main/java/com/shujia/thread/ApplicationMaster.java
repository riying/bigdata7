package com.shujia.thread;

public class ApplicationMaster {

    /**
     * ApplicationMaster
     *
     * 一个mr任务的主程序，负责，资源申请和任务调度
     *
     *
     */

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            //创建线程对象
            Task task = new Task();


        }
    }
}

/**
 * 创建线程
 * <p>
 * 1、计算Thread类或者实现runable接口
 */

class Task extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

    }
}


