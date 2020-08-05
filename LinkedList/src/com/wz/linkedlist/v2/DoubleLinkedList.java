package com.wz.linkedlist.v2;

/**
 * @author 隔壁老王
 * @create 2020-05-18 19:31
 * @微信公众号 隔壁老王说Java
 * @description 实现双向链表（使用虚拟头结点）
 */
public class DoubleLinkedList<E> {

    // 虚拟头结点
    private Node first;
    // 尾结点，指向最后一个节点
    private Node last;
    // 元素个数
    private int size;

    public DoubleLinkedList() {
        first = new Node();
    }

    // 添加元素
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("索引不符合要求");
        }

        Node node = new Node(e);
        if (index == size){
            if (index == 0){    // 插入第一个元素
                first.next = node;
                node.prev = first;
                last = node;
            }else {
                node.next = last.next;
                node.prev = last;
                last.next = node;
                last = node;
            }
        }else {
            Node temp = get(index);
            node.next = temp;
            node.prev = temp.prev;
            temp.prev.next = node;
            temp.prev = node;
        }
        size++;
    }

    // 删除元素
    public E remove(int index){
        // 获取待删除节点
        Node temp = get(index);

        temp.prev.next = temp.next;
        if (index == size - 1){
            last = temp.prev;
        }else {
            temp.next.prev = temp.prev;
        }
        size--;
        return temp.e;
    }

    // 修改元素
    public void set(int index,E e){
        Node node = get(index);
        node.e = e;
    }

    // 获取节点
    public Node get(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引不符合要求");
        }
        // 从头部查找
        if (index < (size >> 1)) {  // >> 移位运算，相当于除以2，效率更高
            Node node = first.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            // 从尾部查找
            Node node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    // 获取元素个数
    public int getSize(){
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 清空链表
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("linked list size: %d, ", getSize()));
        sb.append("first->");
        Node p = first;

        for (int i = 0; i < size; i++) {
            sb.append(p.next.e + "->");
            p = p.next;
        }

        sb.append("last");
        return sb.toString();
    }

    //节点类，使用内部类实现
    private class Node{
        // 存放的数据
        public E e;
        // 前一个节点、下一个节点
        public Node prev,next;

        public Node() {
            this(null,null,null);
        }

        public Node(E e) {
            this(e,null,null);
        }

        public Node(E e, Node prev, Node next) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
