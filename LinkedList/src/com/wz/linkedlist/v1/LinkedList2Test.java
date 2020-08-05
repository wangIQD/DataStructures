package com.wz.linkedlist.v1;

/**
 * @author 隔壁老王
 * @create 2020-05-16 17:13
 * @微信公众号 隔壁老王说Java
 * @description 单链表测试
 */
public class LinkedList2Test {
    public static void main(String[] args) {
        LinkedList2<Integer> linkedList = new LinkedList2<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);

        linkedList.add(2, 888);
        linkedList.add(2, 888);
        System.out.println(linkedList);

        linkedList.removeE(888);

        System.out.println(linkedList);

        System.out.println(linkedList.get(3));

        System.out.println(linkedList);

        linkedList.set(2,100);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(100));

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);


    }
}
