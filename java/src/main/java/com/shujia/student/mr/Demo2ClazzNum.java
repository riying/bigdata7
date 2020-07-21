package com.shujia.student.mr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Demo2ClazzNum {
    public static void main(String[] args) throws Exception {


        long start = System.currentTimeMillis();


        /*
         *统计每个班级学生的人数
         *
         * 1、读取数据
         * 2、切分数据
         *
         *
         */

        FileReader fileReader = new FileReader("java/data/big_students.txt");
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

        bufferedReader.close();

        System.out.println(clazzNum);

        long end = System.currentTimeMillis();

        System.out.println(end - start);


    }
}
