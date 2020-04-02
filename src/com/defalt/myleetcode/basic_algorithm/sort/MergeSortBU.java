package com.defalt.myleetcode.basic_algorithm.sort;
/*
 *  author: Derrick
 *  Time: 2020/4/2 16:44
 */

import com.defalt.myleetcode.basic_algorithm.TestData;

import java.util.Arrays;

public class MergeSortBU implements IArraySort {


    private static void merge(int[] arr, int[] tempArr, int startIndex, int middleIndex, int endIndex) {

        tempArr = Arrays.copyOf(arr, arr.length);
        int left = startIndex;
        int right = middleIndex;

        for (int i = startIndex; i < endIndex; i++) {
            if (left > middleIndex) {
                arr[i] = tempArr[right++];
            } else if (right > endIndex) {
                arr[i] = tempArr[left++];
            } else if (tempArr[left] > tempArr[right]) {
                arr[i] = tempArr[right++];
            } else {
                arr[i] = tempArr[left++];
            }
        }
    }

    @Override
    public int[] sort(int[] arraySource) {
        int[] arr = Arrays.copyOf(arraySource, arraySource.length);
        int[] tempArr = new int[arr.length];
        int n = arr.length;
        // 这里sz是组的大小，从1开始，每次循环组大小翻倍
        for (int sz = 1; sz< n; sz = sz+sz){
            // 遍历数组开始合并，
            for (int lo = 0; lo< n-sz; lo+= sz + sz){
                // endIndex 对于数组长度不满足2的x次幂的数组，mid可能会大于end， 所以要求两者中小的来保证数组末尾不越界
                int endIndex = Math.min(lo+sz+sz-1, n-1);
                merge(arr, tempArr, lo, lo+sz-1, endIndex);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        MergeSortBU mergeSortBU = new MergeSortBU();
//
//        int[] result = shellSort.sort(TestData.testData_0);
        int[] result = mergeSortBU.sort(TestData.testData_1);
        for (int i : result) {
            System.out.println(i);
        }

    }

}
