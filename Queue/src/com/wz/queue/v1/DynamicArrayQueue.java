package com.wz.queue.v1;

/**
 * @author 隔壁老王
 * @create 2020-05-14 18:32
 * @微信公众号 隔壁老王说Java
 * @description 基于动态数组（DynamicArray是自己实现的类）实现的的单向队列
 */
public class DynamicArrayQueue<E> implements Queue<E> {

    private DynamicArray<E> dynamicArray;

    public DynamicArrayQueue() {
        this.dynamicArray = new DynamicArray<>();
    }

    public DynamicArrayQueue(int capacity) {
        this.dynamicArray = new DynamicArray<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        dynamicArray.addLast(e);
    }

    @Override
    public E dequeue() {
        return dynamicArray.removeFirst();
    }

    @Override
    public E getFront() {
        return dynamicArray.getFirst();
    }

    @Override
    public int getSize() {
        return dynamicArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return dynamicArray.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("队列: ");
        res.append("队头 [");
        for(int i = 0 ; i < dynamicArray.getSize() ; i ++){
            res.append(dynamicArray.get(i));
            if(i != dynamicArray.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] 队尾");
        return res.toString();
    }
}
