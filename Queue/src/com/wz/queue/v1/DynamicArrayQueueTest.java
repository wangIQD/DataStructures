package com.wz.queue.v1;

/**
 * @author 隔壁老王
 * @create 2020-05-14 20:23
 * @微信公众号 隔壁老王说Java
 * @description 单向队列测试类
 */
public class DynamicArrayQueueTest {
    public static void main(String[] args) {
        DynamicArrayQueue<Integer> queue = new DynamicArrayQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            // 每添加三个数出队一个数
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
