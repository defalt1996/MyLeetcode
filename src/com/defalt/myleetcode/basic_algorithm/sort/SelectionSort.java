package com.defalt.myleetcode.basic_algorithm.sort;
/*
 *  author: Derrick
 *  Time: 2020/4/1 16:50
 */

import com.defalt.myleetcode.basic_algorithm.TestData;

public class SelectionSort implements IArraySort{



    @Override
    public int[] sort(int[] arraySource) {
        return new int[0];
    }

    public static void main(String[] args) {
        SelectionSort bubbleSort = new SelectionSort();

//        int[] result = bubbleSort.sort(TestData.testData_1);
//        int[] result = bubbleSort.sort2(TestData.testData_1);
        int[] result = bubbleSort.sort(TestData.testData_1);
        for (int i: result){
            System.out.println(i);
        }

    }
}
