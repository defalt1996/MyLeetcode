package com.defalt.myleetcode.leetcode.easy;
/*
 *  author: Derrick
 *  Time: 2020/3/19 22:08
 */

public class LongestCommonPrefix_14 {
    // 两个两个找
    public String longestCommonPrefix(String[] strs) {

        String result = "";

        /*
        未排除数组长度为1的情况，若字符串数组长度为1，根本不走循环。
        */
        if(strs.length == 1){
            result = strs[0];
        }

        for (int i= 1; i< strs.length; i++){

            if (i == 1){
                result = findPrefixIn2Words(strs[i-1], strs[i]);
            }else{
                String tempResult = findPrefixIn2Words(result, strs[i]);

                if(!tempResult.equals("")){
                    result = tempResult;
                }else{
                    return "";
                }
            }
        }
        return result;

    }


    private String findPrefixIn2Words(String s1, String s2){

        String result = "";
        int length = (s1.length() > s2.length()) ?s2.length() :s1.length();

        for (int i = 0; i< length; i++){
            if (s1.charAt(i) == (s2.charAt(i)) ){
                result = result + s1.charAt(i);
            }else{
                return result;
            }
        }
        return result;
    }


}
