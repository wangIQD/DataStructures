package com.wz.queue.v2;

/**
 * @author 隔壁老王
 * @create 2020-05-14 18:31
 * @微信公众号 隔壁老王说Java
 * @description
 */
public interface Queue<E> {
    // 入队
    void enqueue(E e);

    // 出队
    E dequeue();

    // 查看队头元素
    E getFront();

    // 获取队列中元素个数
    int getSize();

    // 判断队列是否为空
    boolean isEmpty();
}
