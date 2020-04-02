package com.defalt.myleetcode.basic_algorithm.sort;
/*
 *  author: Derrick
 *  Time: 2020/4/1 16:50
 */

import com.defalt.myleetcode.basic_algorithm.TestData;

import java.util.Arrays;

public class SelectionSort implements IArraySort{



    @Override
    public int[] sort(int[] arraySource) {

        int[] arr = Arrays.copyOf(arraySource, arraySource.length);

        for (int i = 0; i<arr.length ; i++){

            // 最小元素的坐标
            int minIndex = i;

            // 遍历剩下未排序的元素，记下最小坐标，与i交换
            for (int j = i; j< arr.length ; j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            //把选出来最小与i进行交换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

//        int[] result = bubbleSort.sort(TestData.testData_1);
//        int[] result = bubbleSort.sort2(TestData.testData_1);
//        int[] result = selectionSort.sort(TestData.testData_1);
        int[] result = selectionSort.sort(TestData.testData_0);
        for (int i: result){
            System.out.println(i);
        }

    }
}
