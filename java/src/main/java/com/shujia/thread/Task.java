package com.shujia.thread;

import java.io.Serializable;

/**
 * 创建线程
 * <p>
 * 1、计算Thread类或者实现runable接口
 *
 *
 * task需要在网络中传输所有需要实现Serializable接口
 *
 * 序列化
 *      java对象 ---->  字节码数据
 *
 * 反序列化
 *      字节码数据  --->  对象
 */

public class Task extends Thread implements Serializable {
    @Override
    public void run() {

        /*
         * map端和reduce自定义代码逻辑
         *
         */
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

    }
}

