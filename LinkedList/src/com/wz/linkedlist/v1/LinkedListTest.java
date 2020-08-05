package com.wz.linkedlist.v1;

/**
 * @author 隔壁老王
 * @create 2020-05-16 17:13
 * @微信公众号 隔壁老王说Java
 * @description 单链表测试
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 888);
        linkedList.add(2, 888);
        linkedList.add(2, 888);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.removeE(888);
        System.out.println(linkedList);
    }
}
