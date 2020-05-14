package com.wz.stack;

/**
 * @author 隔壁老王
 * @create 2020-05-14 17:00
 * @微信公众号 隔壁老王说Java
 * @description 基于动态数组（DynamicArray是自己实现的类）的栈
 */
public class DynamicArrayStack<E> implements Stack<E> {

    DynamicArray<E> dynamicArray;

    public DynamicArrayStack() {
        this.dynamicArray = new DynamicArray<>();
    }

    public DynamicArrayStack(int capacity) {
        this.dynamicArray = new DynamicArray<>(capacity);
    }

    @Override
    public void push(E e) {
        dynamicArray.addLast(e);
    }

    @Override
    public E pop() {
        return dynamicArray.removeLast();
    }

    @Override
    public E peek() {
        return dynamicArray.getLast();
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
        res.append("Stack: 栈底 ");
        res.append('[');
        for(int i = 0 ; i < dynamicArray.getSize() ; i ++){
            res.append(dynamicArray.get(i));
            if(i != dynamicArray.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] 栈顶");
        return res.toString();
    }
}
