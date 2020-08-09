package com.wz.linkedlist.v4;


/**
 * @author 隔壁老王
 * @create 2020-05-18 19:32
 * @微信公众号 隔壁老王说Java
 * @description 双链表测试类
 */
public class DoubleCircleLinkedListTest {
    public static void main(String[] args) {
        DoubleCircleLinkedList<Integer> linkedList = new DoubleCircleLinkedList<>();
        linkedList.add(0,1);
        linkedList.add(1,2);
        linkedList.add(0,3);
        linkedList.add(1,4);
        linkedList.add(0,5);

        System.out.println("index = 2 的元素: " + linkedList.get(2));
        System.out.println("链表: " + linkedList);

        linkedList.remove(4);
        linkedList.remove(0);
        System.out.println("链表: " + linkedList);
        linkedList.remove(1);
        System.out.println("链表: " + linkedList);
        linkedList.remove(1);
        System.out.println("链表: " + linkedList);
        linkedList.remove(0);
        System.out.println("链表: " + linkedList);
    }
}
