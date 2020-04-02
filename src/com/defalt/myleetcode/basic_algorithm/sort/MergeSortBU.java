package com.defalt.myleetcode.basic_algorithm.sort;
/*
 *  author: Derrick
 *  Time: 2020/4/2 16:44
 */

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
        for (int sz = 1; sz< n; sz = sz+sz){
            for (int lo = 0; lo< n-sz; lo+= sz + sz){
                merge(arr, tempArr, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1));
            }
        }

        return arr;
    }


}
