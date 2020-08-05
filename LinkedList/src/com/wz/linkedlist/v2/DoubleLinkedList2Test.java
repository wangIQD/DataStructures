package com.wz.linkedlist.v2;


/**
 * @author 隔壁老王
 * @create 2020-05-18 19:32
 * @微信公众号 隔壁老王说Java
 * @description 双链表测试类
 */
public class DoubleLinkedList2Test {
    public static void main(String[] args) {
        DoubleLinkedList2<Integer> linkedList = new DoubleLinkedList2<>();
        linkedList.add(0,1);
        linkedList.add(0,2);
        linkedList.add(0,3);
        linkedList.add(0,4);
        linkedList.add(0,5);

        System.out.println("index = 2 的元素: " + linkedList.get(2));
        System.out.println("链表: " + linkedList);

        linkedList.remove(4);
        System.out.println("链表: " + linkedList);
        System.out.println("链表的 size: " + linkedList.getSize());
        linkedList.remove(0);
        System.out.println("链表: " + linkedList);
        linkedList.remove(2);
        System.out.println("链表: " + linkedList);
        linkedList.set(1,10);
        System.out.println("链表: " + linkedList);
        System.out.println("isEmpty: " + linkedList.isEmpty());
        linkedList.clear();
        System.out.println("链表: " + linkedList);


    }
}
