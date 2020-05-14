package com.wz.stack;

/**
 * @author 隔壁老王
 * @create 2020-05-14 16:57
 * @微信公众号 隔壁老王说Java
 * @description
 */
public interface Stack<E> {

    // 添加元素
    void push(E e);

    // 取出元素
    E pop();

    // 查看栈顶元素
    E peek();

    // 获取栈中元素个数
    int getSize();

    // 判断栈是否为空
    boolean isEmpty();
}
