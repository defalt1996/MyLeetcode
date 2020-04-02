package com.defalt.myleetcode.basic_algorithm.sort;
/*
 *  author: Derrick
 *  Time: 2020/4/1 16:52
 */

import com.defalt.myleetcode.basic_algorithm.TestData;

import javax.print.attribute.standard.SheetCollate;
import java.util.Arrays;

public class ShellSort implements IArraySort {


    // 五分钟算法的实现
    public int[] sort1(int[] arraySource) {

        int[] arr = Arrays.copyOf(arraySource, arraySource.length);

        int length = arr.length;

        int gap = 1;
        while (gap < length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int tmp = arr[i];
                int j = i - gap;

                //组中排序
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];

                    // 游标走到组中上一个元素
                    j -= gap;
                }

                //因为在组中排序的最后会减掉一个间距，所以这里要把间距加上, i 坐标放temp，和插入排序类似
                arr[j + gap] = tmp;
            }
            gap = gap / 3;
        }
        return arr;
    }

    // 自己的实现
    public int[] sort(int[] arraySource) {

        int[] arr = Arrays.copyOf(arraySource, arraySource.length);

        int length = arr.length;

        // 分组
        for (int i = length / 2; i > 0; i /= 2) {
            int gap = i;
            //遍历数组
            for (int j = gap; j < arr.length; j++) {

                int value = arr[j];
                //组内排序
                for (int k = j; k >= 0; k = k - gap) {

                    // 达成交换条件
                    if (arr[k] > value) {
                        arr[k + gap] = arr[k];
                        arr[k] = value;
                    }

                }
            }
        }
        return arr;
    }

    public int[] sort2(int[] arraySource) {

        int[] arr = Arrays.copyOf(arraySource, arraySource.length);

        int j = 0;
        int temp = 0;
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            System.out.println("increment:" + increment);

            for (int i = increment; i < arr.length; i++) {
                temp = arr[i];

                // 其实就是相当于把插入排序外边套了一层改变gap的循环，里边把1换成gap
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < arr[j]) {
                        arr[j + increment] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + increment] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
//        int[] result = shellSort.sort(TestData.testData_0);
        int[] result = shellSort.sort(TestData.testData_1);
        for (int i : result) {
            System.out.println(i);
        }

    }

}
