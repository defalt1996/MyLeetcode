package com.defalt.myleetcode.basic_algorithm.sort;
/*
 *  author: Derrick
 *  Time: 2020/4/1 16:53
 */

import com.defalt.myleetcode.basic_algorithm.TestData;

import java.util.Arrays;

public class MergeSort implements IArraySort{


    // 自定向下， 递归的解法
    @Override
    public int[] sort(int[] arraySource) {
        int[] arr = Arrays.copyOf(arraySource, arraySource.length);
        int[] tempArr = new int[arr.length];
        sort(arr, tempArr, 0, tempArr.length-1);

        return arr;
    }

    private static void sort(int[] arr, int[] tempArr, int startIndex, int endIndex){
        if (endIndex <= startIndex){
            return;
        }
        int middleIndex = startIndex + (endIndex - startIndex)/2;
        sort(arr, tempArr, startIndex, middleIndex);
        sort(arr, tempArr, middleIndex+1, endIndex);
        merge(arr, tempArr, startIndex, middleIndex, endIndex);
    }



    private static void merge(int[] arr, int[] tempArr, int startIndex, int middleIndex, int endIndex){
        tempArr = Arrays.copyOf(arr, arr.length);

        int left = startIndex;
        int right = middleIndex;

        for (int i = startIndex; i<= endIndex; i++){
         if (left > middleIndex){
             arr[i] = tempArr[right++];
         }else if (right > endIndex){
             arr[i] = tempArr[left++];
         }else if (tempArr[left] > tempArr[right]){
             arr[i] = tempArr[right++];
         }else {
             arr[i] = tempArr[left++];
         }
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
//
//        int[] result = shellSort.sort(TestData.testData_0);
        int[] result = mergeSort.sort(TestData.testData_1);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
