package com.defalt.myleetcode.basic_algorithm.search;
/*
 *  author: Derrick
 *  Time: 2020/4/26 22:53
 */

public class AVL<T extends Comparable<T>> {

    private AVLTreeNode<T> mRoot;

    class AVLTreeNode<T extends Comparable<T>>{

        T key;
        int height;
        AVLTreeNode<T> left;
        AVLTreeNode<T> right;

    }

    private int height(AVLTreeNode<T> node){
        if ( node != null){
            return node.height;
        }
        return 0;
    }

    public int height(){
        return height(mRoot);
    }

    // LL : 右旋转 return: 旋转后子树的根节点（实际的node）
    private AVLTreeNode<T> LL_Rotate(AVLTreeNode<T> node){
        //node 最小失衡子树

        //最小失衡子树的左子树
        AVLTreeNode<T> node_lc = node.left;
        // 将左子树的右子树挂在node的左子树上
        node.left = node_lc.right;
        // 把node赋给左子树的右子树
        node_lc.right = node;

        // TODO: 2020/4/26
        //更新高度+1的理解？
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        node_lc.height = Math.max(height(node_lc.left), node.height) + 1;;

        return node_lc;
    }

    //RR 左旋
    private AVLTreeNode<T> RR_rotate(AVLTreeNode<T> node){

        AVLTreeNode<T> node_rc = node.right;
        node.right = node_rc.left;
        node_rc.left = node;

        // 更新高度
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        node_rc.height = Math.max(node.height, height(node_rc.right)) + 1;

        return node_rc;
    }




}
