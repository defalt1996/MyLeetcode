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

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
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
        node_lc.height = Math.max(height(node_lc.left), node.height) + 1;

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

    // LR 先左旋后右旋 （左旋最小失衡结点的左孩子，然后右旋自己）
    private AVLTreeNode<T> LR_rotate(AVLTreeNode<T> node){
        RR_rotate(node.left);
        return LL_Rotate(node);
    }

    // LR 先左旋后右旋 （左旋最小失衡结点的左孩子，然后右旋自己）
    private AVLTreeNode<T> RL_rotate(AVLTreeNode<T> node){
        LL_Rotate(node.right);
        return RR_rotate(node);
    }

    // 插入 (迭代) return：插入的结点
    private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key){

        // 若该插入的位置为空 新建结点
        if (tree == null){

            tree = new AVLTreeNode<>(key, null, null);

        }else {

            // 将要插入的key与当前结点比较
            int cmp = key.compareTo(tree.key);

            //插入左子树
            if (cmp < 0){
                // 直接插入当前结点的左孩子位置
                tree.left = insert(tree.left, key);
                // 如果插入后失去平衡
                if ((height(tree.left) - height(tree.right)) > 1){

                    // 判断是插入了最小失衡结点的左子树/右子树 ——的左子树
                    if (key.compareTo(tree.left.key) < 0){
                        // 如果比最小失衡结点的左子树小，那么就是在左子树上，执行右旋
                        tree = LL_Rotate(tree);
                    }else {
                        // 否则是右子树的左子树，执行LR
                        tree = LR_rotate(tree);
                    }
                }
                // 插入当前结点的右孩子位置
            }else if (cmp > 0){
                tree.right = insert(tree.right, key);

                // 失衡
                if ((height(tree.right) - height(tree.left)) > 1){
                    // 判断是插在最小失衡节点的左子树还是右子树
                    if (key.compareTo(tree.right.key) > 0){
                        tree = RR_rotate(tree);
                    }else {
                        tree = RL_rotate(tree);
                    }
                }
            }else { // cmp == 0， 存在该key,不可添加

            }
        }

        tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }


}
