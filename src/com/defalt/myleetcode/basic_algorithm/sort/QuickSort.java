package com.defalt.myleetcode.basic_algorithm.sort;
/*
 *  author: Derrick
 *  Time: 2020/4/1 16:54
 */

import com.defalt.myleetcode.basic_algorithm.TestData;

import java.util.Arrays;

public class QuickSort implements IArraySort{

    /*
    * 快速排序是冒泡排序的一种改进
    * 递归解法
    * 1. 每次把要快排的数组的第一个元素当作基准，Pivot
    * 2. 设定两个哨兵，i从左往右，j从右往左遍历（先开始），j遇到比pivot小的元素停止，i遇到比pivot大的元素停止。
    * 3. 交换i j 所在的元素，继续遍历
    * 4. 当ij相遇时，将所在元素与pivot交换.
    * 5. 继续递归
    *
    *
    * */
    @Override
    public int[] sort(int[] arraySource) {

        int[] arr = Arrays.copyOf(arraySource, arraySource.length);

        sort(arr, 0, arr.length-1);

        return arr;
    }

    private void sort(int[] arr, int startIndex, int endIndex){

        if (startIndex > endIndex){
            return;
        }


        int i = startIndex;
        int j = endIndex;
        int pivot = arr[startIndex];


        while (i!=j){

            int temp = 0;

            while (arr[j] >= pivot && i<j){
                j--;
            }
            while (arr[i] <= pivot && i<j){
                i++;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        int t = arr[i];
        arr[i] = arr[startIndex];
        arr[startIndex] = t;

        sort( arr, startIndex, i-1);
        sort( arr, i+1, endIndex);

    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
//
//        int[] result = shellSort.sort(TestData.testData_0);
        int[] result = quickSort.sort(TestData.testData_1);
        for (int i : result) {
            System.out.println(i);
        }

    }



}
