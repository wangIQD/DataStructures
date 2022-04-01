package com.wz.stack.v1;

/**
 * @author 隔壁老王
 * @create 2022-04-01
 * @微信公众号 隔壁老王说Java
 * @description 顺序栈: 基于动态数组（DynamicArray是自己实现的类）实现的栈
 */
public class DynamicArrayStack<E> implements Stack<E> {
    private DynamicArray<E> dynamicArray;

    public DynamicArrayStack() {
        this.dynamicArray = new DynamicArray<>();
    }

    public DynamicArrayStack(int capacity) {
        this.dynamicArray = new DynamicArray<>(capacity);
    }

    // 入栈
    @Override
    public void push(E e) {
        dynamicArray.addLast(e);
    }

    // 出栈
    @Override
    public E pop() {
        if (dynamicArray.isEmpty()){
            throw new RuntimeException("栈为空，没有可出栈元素");
        }
        return dynamicArray.removeLast();
    }

    // 获取栈定元素
    @Override
    public E peek() {
        if (dynamicArray.isEmpty()){
            throw new RuntimeException("栈为空，没有栈顶元素");
        }
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
