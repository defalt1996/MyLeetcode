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
            //内部每次把最大的一个冒泡到最后，然后内部循环长度减少一个 （length - i -1）
            for (int j=0; j< arr.length - i -1; j++){
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
            //设置一个flag 先置为内部循环没被交换过
            boolean isSorted = false;

            for (int j = 0; j< arr.length-i-1; j++){

                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // 交换过了，置为true
                    isSorted = true;
                }

            }
            // 如果一遍下来都未交换过，证明已经有序了 停止外部循环 结束
            if (!isSorted) break;

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

        int[] result = bubbleSort.sort(TestData.testData_4);
//        int[] result = bubbleSort.sort(TestData.testData_1);
//        int[] result = bubbleSort.sort2(TestData.testData_1);
//        int[] result = bubbleSort.sort3(TestData.testData_1);
        for (int i: result){
            System.out.println(i);
        }

    }
}
