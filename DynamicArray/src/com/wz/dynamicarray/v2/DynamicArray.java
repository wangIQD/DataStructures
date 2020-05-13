package com.wz.dynamicarray.v2;

/**
 * @author 隔壁老王
 * @create 2020-05-12 16:58
 * @description
 */
//动态数组
//v2：添加元素、获取元素、修改元素、删除元素、重写toString方法
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

    // 向所有元素后添加一个新元素
    public void addLast(int e){
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(int e){
        add(0, e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, int e){

        if(size == data.length) {
            throw new IllegalArgumentException("添加失败，数组是满的");
        }

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，index索引不符合要求");
        }

        for(int i = size - 1; i >= index ; i --) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size ++;
    }

    // 获取index索引位置的元素
    public int get(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("获取失败，index索引不符合要求");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, int e){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("修改失败，index索引不符合要求");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(int e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(int e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public int remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("删除失败，index索引不符合要求");
        }

        int temp = data[index];
        for(int i = index + 1 ; i < size ; i ++) {
            data[i - 1] = data[i];
        }
        size --;
        return temp;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public int removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public int removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(int e){
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
