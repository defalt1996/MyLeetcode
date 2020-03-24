package com.defalt.myleetcode.easy;
/*
 *  author: Derrick
 *  Time: 2020/3/24 22:19
 */

public class RemoveDuplicates_26 {

    // 双指针法？
    public int removeDuplicates(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j=1; j< nums.length; j++){

            // 不相等的话， 把j指针的值赋给i+1位置
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }


}
