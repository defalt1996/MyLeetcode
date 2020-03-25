package com.defalt.myleetcode.easy;
/*
 *  author: Derrick
 *  Time: 2020/3/25 15:59
 */

public class RemoveElements_27 {

    public int removeElement(int[] nums, int val) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            /*
            * 我错在哪？
            * 和26一样的双指针 让j指针跑，如果和删除目标不相等，就赋给前面的i指针的值，然后迭代
            *
            *
            *
            * */
//            if (nums[i] == val) {
//                if (nums[j] == val) continue;
//                nums[i] = nums[j];
//
//            }
//            i++;
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }


        }
        return i;
    }

}
