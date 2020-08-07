package com.wz.linkedlist.v3;

/**
 * @author 隔壁老王
 * @create 2020-05-16 17:13
 * @微信公众号 隔壁老王说Java
 * @description 测试单向循环链表
 */
public class SingleCircularLinkedListTest {
    public static void main(String[] args) {
        SingleCircularLinkedList<Integer> linkedList = new SingleCircularLinkedList<>();
        linkedList.add(0,1);
        linkedList.add(0,2);
        linkedList.add(0,3);
        linkedList.add(1,4);
        linkedList.add(0,5);
        linkedList.add(linkedList.getSize(),5);
        System.out.println(linkedList);

        System.out.println(linkedList.get(2));
        System.out.println(linkedList);

        linkedList.set(3,20);
        System.out.println(linkedList);

        linkedList.remove(0);
        System.out.println(linkedList);

        linkedList.remove(linkedList.getSize() - 1);
        System.out.println(linkedList);

        linkedList.remove(1);
        System.out.println(linkedList);
    }
}
