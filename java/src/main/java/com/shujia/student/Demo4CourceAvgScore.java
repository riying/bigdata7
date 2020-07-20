package com.shujia.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Demo4CourceAvgScore {
    public static void main(String[] args) throws Exception {
        /*
         * 计算每个科目的平均分
         *
         */

        FileReader fileReader = new FileReader("java/data/score.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        HashMap<String, Integer> sumScore = new HashMap<String, Integer>();
        HashMap<String, Integer> sumNum = new HashMap<String, Integer>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String cource = line.split(",")[1];
            int score = Integer.parseInt(line.split(",")[2]);


            /**
             * 1、统计每个科目总的分数
             * 2、统计每个科目总的人数
             *
             */

            //总分
            Integer integer = sumScore.get(cource);
            if (integer == null) {
                sumScore.put(cource, score);
            } else {
                sumScore.put(cource, integer + score);
            }


            //总人数
            Integer num = sumNum.get(cource);
            if (integer == null) {
                sumNum.put(cource, 1);
            } else {
                sumNum.put(cource, num + 1);
            }

        }


        for (Map.Entry<String, Integer> entry : sumScore.entrySet()) {
            String cource = entry.getKey();
            Integer score = entry.getValue();

            //获取总人数
            Integer num = sumNum.get(cource);

            double avg = score / (double) num;

            System.out.println(cource + "\t" + avg);
        }


    }
}
