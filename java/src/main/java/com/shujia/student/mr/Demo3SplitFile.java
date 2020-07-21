package com.shujia.student.mr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Demo3SplitFile {
    public static void main(String[] args) throws Exception {


        /**
         * 拆分文件
         *
         * 1、计算文件的总行数
         * 2、计算每个文件的数据行数据
         * 3、拆分文件
         *
         */

        Long fileLength = fileLength("java/data/big_students.txt");

        int size = 8;

        //每个文件分的行数
        long fileRow = fileLength / size;


        /**
         * 拆分文件
         *
         * 每循环fileRow次生成一个新的文件
         *
         */
        FileReader fileReader = new FileReader("java/data/big_students.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        int fileFlag = 0;

        FileWriter fileWriter = new FileWriter("java/data/tmp/part-" + fileFlag);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        long flag = 0;

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            flag++;

            //循环fileRow次，从新打开一个文件
            if (flag > fileRow) {

                bufferedWriter.flush();
                bufferedWriter.close();
                fileWriter.close();

                fileFlag++;
                fileWriter = new FileWriter("java/data/tmp/part-" + fileFlag);
                bufferedWriter = new BufferedWriter(fileWriter);

                flag = 0;
            }

            bufferedWriter.write(line);
            bufferedWriter.newLine();

        }

        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();



    }

    /**
     * 统计文件的行数据
     *
     * @param fileName
     * @return
     */
    public static Long fileLength(String fileName) throws Exception {
        FileReader fileReader = new FileReader("java/data/big_students.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Long fileLength = 0L;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            fileLength++;
        }
        return fileLength;
    }

}
