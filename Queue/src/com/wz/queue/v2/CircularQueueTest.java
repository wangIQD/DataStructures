package com.wz.queue.v2;

/**
 * @author 隔壁老王
 * @create 2020-05-15 17:58
 * @微信公众号 隔壁老王说Java
 * @description 循环队列测试类
 */
public class CircularQueueTest {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        for(int i = 0 ; i < 10 ; i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
