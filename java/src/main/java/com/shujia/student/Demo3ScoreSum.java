package com.shujia.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Demo3ScoreSum {
    public static void main(String[] args) throws Exception {

        /*
         * 计算学生的总分，需要返回学生的基本信息
         *
         *
         */

        FileReader fileReader = new FileReader("java/data/score.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");

            String id = split[0];
            int score = Integer.parseInt(split[2]);

            /*
             * 统计学生总分
             * 如果不存在直接存进去
             * 如果存在加上当前科目再存进去
             *
             */
            Integer sumScore = hashMap.get(id);
            if (sumScore == null) {
                hashMap.put(id, score);
            } else {
                hashMap.put(id, sumScore + score);
            }
        }

        System.out.println(hashMap);


        /**
         * 读取学生表
         *
         * java中通过hashmap实现分组求和和表关联
         *
         */
        FileReader fileReader1 = new FileReader("java/data/students.txt");
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);

        String student;
        while ((student = bufferedReader1.readLine()) != null) {
            String id = student.split(",")[0];

            //获取学生总分
            Integer sumScore = hashMap.get(id);

            System.out.println(student + "\t" + sumScore);

        }

    }
}
