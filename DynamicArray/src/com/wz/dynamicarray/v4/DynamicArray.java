package com.wz.dynamicarray.v4;

/**
 * @author 隔壁老王
 * @create 2020-05-12 16:58
 * @bilibili https://space.bilibili.com/320299990
 * @description
 */
//动态数组
//v4：动态扩容
public class DynamicArray<E> {
    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造DynamicArray
    public DynamicArray(int capacity){
//        data = new E[capacity];   //这种写法是错误的, IDEA会提示让你这样改, 但Java不支持这种写法
        data = (E[]) new Object[capacity];
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
    public void addLast(E e){
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e){
        add(0, e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, E e){
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，index索引不符合要求");
        }
        if(size == data.length) {
            //扩容大小自己决定
            resize(2 * data.length);
        }

        for(int i = size - 1; i >= index ; i --) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size ++;
    }

    // 获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("获取失败，index索引不符合要求");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("修改失败，index索引不符合要求");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e){
        for(int i = 0 ; i < size ; i ++){
            //将==改为equals方法
            if(data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("删除失败，index索引不符合要求");
        }

        E temp = data[index];
        for(int i = index + 1 ; i < size ; i ++) {
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;
        // 此处设为4的原因：防止极端情况，若设为2，当添加一个元素当达到数组最大值时，扩容，
        // 此时删除一个元素，缩容，在添加一个，又扩容。。。如此反复会造成很大的浪费
        if(size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return temp;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
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

    // 具体的扩容方法
    private void resize(int newCapacity){

        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
