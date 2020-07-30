package com.wz.dynamicarray.v1;

/**
 * @author 隔壁老王
 * @create 2020-05-12 16:58
 * @description
 */
//动态数组
//v1版本：搭建基本结构
public class DynamicArray {
    private int[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造DynamicArray
    public DynamicArray(int capacity){
        data = new int[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public DynamicArray(){
        this(10);
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

}
