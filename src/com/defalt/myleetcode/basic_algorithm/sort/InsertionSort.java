package com.defalt.myleetcode.basic_algorithm.sort;
/*
 *  author: Derrick
 *  Time: 2020/4/1 16:51
 */

import com.defalt.myleetcode.basic_algorithm.TestData;

import java.util.Arrays;

/*
* 插入排序
*
* */
public class InsertionSort implements IArraySort{
    @Override
    public int[] sort(int[] arraySource) {

        int[] arr = Arrays.copyOf(arraySource, arraySource.length);

        // 第一个元素就不用插了，从第二个元素开始
        for (int i = 1; i< arr.length; i++){
            //记下当前位置元素值，移动元素的时候位置会被挤掉
            int value = arr[i];
            int j = 0;
            for ( j = i-1; j>= 0; j--){
                // 移动数据记得从队尾开始往外拉！
                if (value< arr[j]){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            // 最后一次和j(前一个元素)比较没有小于j，所以要放到j的后面
            arr[j+1] = value;

        }

        return arr;

    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] result = insertionSort.sort(TestData.testData_0);
//        int[] result = insertionSort.sort(TestData.testData_1);
        for (int i: result){
            System.out.println(i);
        }

    }
}
