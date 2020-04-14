package com.defalt.myleetcode.basic_algorithm.search;
/*
 *  author: Derrick
 *  Time: 2020/4/14 14:11
 */

public class BST<Key extends Comparable<Key>, Value> {

    // 根节点
    private Node root;

    private class Node{

        private Key key;
        private Value value;

        private Node left;
        private Node right;

        // 结点计数器 以该结点为根的子树中的结点个数
        private int N;

        //Constructor
        public Node(Key key, Value value, int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }





    }

    public int size(){
        return size(root);
    }

    private int size(Node x) {
        if (x == null ) return 0;
        else return x.N;
    }

    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node x, Key key){

        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            return get(x.left, key);
        }else if ( cmp> 0 ){
            return get(x.right, key);
        }else {
            return x.value;
        }
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value){

        if ( x == null){
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            x.left = put(x.left, key, value);
        }else if ( cmp >0){
            x.right = put(x.right, key, value);
        }else {
            x.value = value;
        }
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key){

        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0){
            return x;
        }
        if (cmp < 0){
            floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null){
            return x;
        }
        return min(x.left);
    }

    public void deleteMin(){
        deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){

        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            // 没有子节点或只有一个子节点的结点
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;

            // 拥有两个字结点
            //当前结点用t保存
            Node t = x;
            //在右子树中找最小结点（后继结点， 也可用前继节点）
            x = min(t.right);
            // 删除后继结点 (x的右子树指向删除了后继结点后的右子树)
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }



}
