package com.wz.linkedlist.v3;

/**
 * @author 隔壁老王
 * @create 2020-05-16 15:02
 * @微信公众号 隔壁老王说Java
 * @description 实现单向循环链表(不使用虚拟头结点)
 */
public class SingleCircularLinkedList<E> {
    // 头结点，指向链表第一个节点
    private Node head;
    // 存储的节点个数
    private int size;

    // 添加元素，在某一位置添加元素
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("索引不符合要求");
        }

        Node last;
        if(index == 0){
            Node newHead = new Node(e, head);
            if (size == 0){
                last = newHead;
            }else {
                last = get(size - 1);
            }
            last.next = newHead;
            head = newHead;
        }else {
            Node prev = get(index - 1);
            prev.next = new Node(e, prev.next);
        }

        size++;
    }

    // 获取指定位置的节点
    public Node get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引不符合要求");
        }
        // 辅助节点，用于遍历。
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    // 修改元素
    public void set(int index, E e){
        Node node = get(index);
        node.e = e;
    }

    // 删除元素, 返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("索引不符合要求");
        }
        Node temp = head;
        if (index == 0){
            if (size == 1){
                head = null;
            }else {
                Node last = get(size - 1);  // 要先获取last节点，否则会出现问题
                head = head.next;
                last.next = head;
            }
        }else {
            Node prev = get(index - 1);
            temp = prev.next;
            prev.next = temp.next;
        }

        size--;
        return temp.e;
    }

    // 获取元素个数
    public int getSize(){
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("{");
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                res.append(", ");
            }
            res.append(temp);
            temp = temp.next;
        }
        res.append("}");
        return res.toString();
    }

    //节点类，使用内部类实现
    private class Node{
        // 存放的数据
        public E e;
        // 下一个节点
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

}
