package com.shujia.thread;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NodeManager {

    public static void main(String[] args) throws Exception {


        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("NodeManager已启动");

        //等待请求
        Socket accept = serverSocket.accept();


        //获取输入流
        InputStream inputStream = accept.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        //接收发送过来的线程对象
        Task task = (Task) objectInputStream.readObject();

        //启动线程
        task.start();

        objectInputStream.close();
        accept.close();
    }
}
