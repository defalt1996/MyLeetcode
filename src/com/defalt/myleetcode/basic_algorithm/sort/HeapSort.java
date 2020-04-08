package com.defalt.myleetcode.basic_algorithm.sort;
/*
 *  author: Derrick
 *  Time: 2020/4/1 16:56
 */

import java.util.ArrayList;

public class HeapSort implements IArraySort{
    @Override
    public int[] sort(int[] arraySource) {




        return new int[0];
    }


    // 实现一个大顶堆
    class MaxHeap <E extends Comparable<E>>{

        private ArrayList<E> data;

        public MaxHeap(int size){
            data = new ArrayList<>(size);
        }

        public MaxHeap(){
            data = new ArrayList<>();
        }

        public boolean isEmpty(){
            return data.isEmpty();
        }

        public int size(){
            return data.size();
        }

        // 从当前下标获取父节点
        public int parent(int index){
            return (index-1) / 2;
        }

        // 获取左孩子
        public int leftChild(int index){
            return index * 2 + 1;
        }

        //获取有孩子
        public int rightChild(int index){
            return index * 2 + 2;
        }

        // 交换两个元素的位置
        private void swap(int x, int y){
            if (x<0 || x> data.size() || y<0 || y>data.size())
                throw new IllegalArgumentException("index is illegal");

            E temp = data.get(x);
            data.set(x, data.get(y));
            data.set(y, temp);
        }

        // 上浮元素
        private void swiftUp( int index){

            while ( index > 0 && data.get(index).compareTo(data.get(parent(index))) < 0){
                swap(index, parent(index));
                index = parent(index);
            }
        }

        //  加入一个元素，先添加在末尾，然后上浮
        public void add(E element){
            data.add(element);
            swiftUp(data.size() - 1);
        }

        public E findMax(){
            return data.get(0);
        }

        public E extractMax(){

            E temp = findMax();
            data.set(0, data.get(data.size()-1));
            data.remove(data.size()-1);
            swiftDown(0);
            return temp;

        }

        private void swiftDown(int i){

            while ( leftChild(i) < data.size() ){

                // 取两个孩子中的最大值
                int j = leftChild(i);
                if ( j < data.size() && data.get(j+1).compareTo(data.get(j)) > 0){
                    j++;
                }

                //当该节点比孩子节点中最大的还要大时，停止下沉
                if (data.get(j).compareTo(data.get(i)) < 0){
                    break;
                }

                swap(j, i);
                i = j;
            }
        }
    }
}
