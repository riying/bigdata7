package com.shujia.student.mr;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo4Map {
    public static void main(String[] args) throws Exception {

        /**
         * 为每一个文件启动一个线程处理数据
         *
         */

        long start = System.currentTimeMillis();

        //创建线程次=池
        //使用线程池之后线程启动便快
        ExecutorService threadPool = Executors.newFixedThreadPool(8);


        //获取文件列表
        File file = new File("java/data/tmp");
        File[] files = file.listFiles();

        if (files == null) return;


        int flag = 0;
        for (File file1 : files) {
            //为每一个文件启动一个线程
            MapTask mapTask = new MapTask(file1, flag);

            //通过线程池启动线程
            threadPool.submit(mapTask);

            flag++;
        }

        //关闭线程池
        threadPool.shutdown();

        //等待关闭
        threadPool.awaitTermination(100000L, TimeUnit.SECONDS);

        long end = System.currentTimeMillis();

        System.out.println(end - start);


    }
}

class MapTask extends Thread {

    private File file;
    private int flag;

    public MapTask(File file, int flag) {
        this.file = file;
        this.flag = flag;
    }

    @Override
    public void run() {
        //处理处理

        try {
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            /*
             *统计每个班级的人数
             */

            //存储计算结果的map
            HashMap<String, Integer> clazzNum = new HashMap<String, Integer>();

            while ((line = bufferedReader.readLine()) != null) {
                String clazz = line.split(",")[4];

                //判断班级是否存在
                //如果存在返回人数，不存在返回null
                Integer integer = clazzNum.get(clazz);

                if (integer == null) {
                    //不存在的时候put一个1
                    clazzNum.put(clazz, 1);
                } else {
                    //存在的时候加1
                    clazzNum.put(clazz, integer + 1);
                }
            }


            //将每一个先统计的结果保存磁盘中
            FileWriter fileWriter = new FileWriter("java/data/tmp2/part-" + flag);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Map.Entry<String, Integer> entry : clazzNum.entrySet()) {
                String clazz = entry.getKey();

                Integer num = entry.getValue();

                bufferedWriter.write(clazz + "," + num);
                bufferedWriter.newLine();
            }


            bufferedWriter.close();
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

