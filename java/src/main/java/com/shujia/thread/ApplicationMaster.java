package com.shujia.thread;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ApplicationMaster {

    /**
     * ApplicationMaster
     * <p>
     * 一个mr任务的主程序，负责，资源申请和任务调度
     */

    public static void main(String[] args) throws Exception {


        //创建线程对象
        Task task = new Task();


        Socket socket = new Socket("localhost", 8888);

        OutputStream outputStream = socket.getOutputStream();

        /*
         * 发送对象需要使用对象流
         *
         */
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        System.out.println("正在调度task");
        //发送task到nodemanager中
        objectOutputStream.writeObject(task);
        objectOutputStream.flush();



        //io流和网络资源用完一定要关闭
        objectOutputStream.close();
        socket.close();

    }
}


