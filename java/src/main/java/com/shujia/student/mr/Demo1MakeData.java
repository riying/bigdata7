package com.shujia.student.mr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Demo1MakeData {
    public static void main(String[] args) throws Exception {

        /**
         * 将数据量变大
         *
         */
        FileReader fileReader = new FileReader("java/data/students.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);


        FileWriter fileWriter = new FileWriter("java/data/big_students.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            for (int i = 0; i < 50000; i++) {

                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();

        }

        bufferedWriter.close();
        bufferedReader.close();
    }
}
