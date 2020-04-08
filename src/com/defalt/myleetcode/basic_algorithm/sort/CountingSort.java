package com.defalt.myleetcode.basic_algorithm.sort;
/*
 *  author: Derrick
 *  Time: 2020/4/1 16:57
 */

import com.defalt.myleetcode.basic_algorithm.TestData;

import java.util.Arrays;

public class CountingSort implements IArraySort{

    /*
    * 计数排序
    * 五分钟学算法还有一个关于考试成绩排名的实现，暂时不看了
    *
    * */

    @Override
    public int[] sort(int[] arraySource) {

        int[] arr = Arrays.copyOf(arraySource, arraySource.length);
        int max = arr[0];
        // 找出最大值
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }

        int[] countArr = new int[max+1];

        // 遍历数组计数，填入计数数组
        for (int i = 0; i< arr.length; i++){
            countArr[arr[i]] ++;
        }

        // 排序
        int index = 0;
        for (int i = 0; i< countArr.length; i++){
            while (countArr[i] > 0){
                arr[index] = i;
                countArr[i] --;
                index ++;
            }
            // 五分钟学算法的实现，有错
//            if (countArr[i] > 0) {
//                arr[index++] = i;
//            }
        }

        return arr;
    }

    public static void main(String[] args) {

        CountingSort countingSort = new CountingSort();

        //        int[] result = shellSort.sort(TestData.testData_0);
        int[] result = countingSort.sort(TestData.testData_3);
        for (int i : result) {
            System.out.println(i);
        }

    }



}
