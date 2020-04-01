package com.defalt.myleetcode.basic_algorithm.sort;
/*
 *  author: Derrick
 *  Time: 2020/3/31 16:51
 */

import com.defalt.myleetcode.basic_algorithm.TestData;

import java.util.Arrays;

public class BubbleSort implements IArraySort {

    //无优化：两轮循环冒泡
    /*
    * 第一次解，我竟然在 第二层循环中的if后加了else？？？ 第二次循环一定每个都走一遍把最大的推到最后的。
    *
    * */
    @Override
    public int[] sort(int[] arraySource) {

        int[] arr = Arrays.copyOf(arraySource, arraySource.length);
        for (int i=0; i< arr.length; i++){
            for (int j=i; j< arr.length - i -1; j++){
                int temp = 0;
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    // 优化1：设置flag如果数组已经有序，则停止循环
    public int[] sort2(int[] arraySource) {

        int[] arr = Arrays.copyOf(arraySource, arraySource.length);
        for (int i=0; i< arr.length; i++){
            boolean isSorted = true;

            for (int j = i; j< arr.length-i-1; j++){

                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSorted = false;
                }

            }
            if (isSorted == true) break;

        }

        return arr;
    }

    // 优化2：设置边界值，针对某种特殊数组，例如100个元素，前10个无序，后90个都是有序的 但是这种并不常见。
    public int[] sort3(int[] arraySource) {

        int[] arr = Arrays.copyOf(arraySource, arraySource.length);

//        int k = arr.length;
//        for (int i=0; i< k; i++){
//
//            for (int j = i; j< k-i-1; j++){
//
//                if (arr[j] > arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                    k = j+1;
//                }
//
//            }
//        }

        return arr;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

//        int[] result = bubbleSort.sort(TestData.testData_1);
//        int[] result = bubbleSort.sort2(TestData.testData_1);
        int[] result = bubbleSort.sort3(TestData.testData_1);
        for (int i: result){
            System.out.println(i);
        }

    }
}
