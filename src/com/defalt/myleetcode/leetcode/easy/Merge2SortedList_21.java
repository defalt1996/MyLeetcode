package com.defalt.myleetcode.leetcode.easy;
/*
 *  author: Derrick
 *  Time: 2020/3/20 0:03
 */

public class Merge2SortedList_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // ListNode result = new ListNode( (l1.val > l2.val) ? l2.val : l1.val)
        ListNode result = new ListNode(0);
        ListNode temp = result;

        while (l1!=null || l2!=null){

            if (l1 == null){
                temp.next = l2;
                break;
            }
            if (l2 == null){
                temp.next = l1;
                break;
            }

            while ((l1 != null) && (l2!=null) &&(l1.val < l2.val)){
                temp.next = new ListNode(l1.val);
                temp = temp.next;
                System.out.println("add l1:"+l1.val);
                l1 = l1.next;
                if (l1 == null){
                    break;
                }
            }
            while ((l1 != null) && (l2!=null) &&(l1.val > l2.val)){
                temp.next = new ListNode(l2.val);
                temp = temp.next;
                System.out.println("add l2:"+l2.val);
                l2 = l2.next;
                if (l2 == null){
                    break;
                }
            }
            while ((l1 != null) && (l2!=null) &&(l1.val == l2.val) ){
                temp.next = new ListNode(l1.val);
                temp.next.next = new ListNode(l1.val);
                System.out.println("add l1 & l2:"+l1.val);
                l1 = l1.next;
                l2 = l2.next;
                temp = temp.next.next;
                if (l1 == null || l2==null){
                    break;
                }
            }
        }
        return result.next;
    }

    /*
    * 直接翻译了数学模型
    * l1[0] + merge(l1[1:], l2)   if (l1[0]<l2[0])
    * l2[0] + merge(l1, l2[1:])   else
    *
    * */
    public ListNode mergeInRecursionWay(ListNode l1, ListNode l2){

        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return  l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }


    }


    // Why this internal class need to be static?
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
//        ListNode l12 = new ListNode(0);
//        ListNode l13 = new ListNode(0);

//        l11.next = l12;
//        l12.next = l13;

        ListNode l21 = new ListNode(1);
//        ListNode l22 = new ListNode(0);
//        ListNode l23 = new ListNode(0);

//        l21.next = l22;
//        l22.next = l23;

        Merge2SortedList_21 solution = new Merge2SortedList_21();
//        ListNode result = solution.mergeTwoLists(l11, l21);
        ListNode result = solution.mergeInRecursionWay(l11, l21);
        while (result != null){
            System.out.print(result.val);
            result = result.next;
        }

    }
}
