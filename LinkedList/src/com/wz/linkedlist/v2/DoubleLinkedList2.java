package com.wz.linkedlist.v2;

/**
 * @author 隔壁老王
 * @create 2020-05-18 19:31
 * @微信公众号 隔壁老王说Java
 * @description 实现双链表（不使用虚拟头结点）
 */
public class DoubleLinkedList2<E> {

    // 头结点，指向链表第一个节点
    private Node first;
    // 尾结点，指向链表最后一个节点
    private Node last;
    // 元素个数
    private int size;

    // 添加元素
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("索引不符合要求");
        }
        if (index == size){ // 往最后面添加元素
            Node oldLast = last;
            last = new Node(e, oldLast, null);
            if (oldLast == null){   // 这是链表添加的第一个元素
                first = last;
            }else {
                oldLast.next = last;
            }
        }else {
            Node next = get(index);
            Node prev = next.prev;
            Node node = new Node(e,prev,next);
            next.prev = node;

            if (prev == null){  // index == 0
                first = node;
            }else {
                prev.next = node;
            }
        }
        size++;
    }

    // 删除元素
    public E remove(int index){
        Node temp = get(index);

        if (temp.prev == null){     // index == 0
            first = temp.next;
        }else {
            temp.prev.next = temp.next;
        }

        if (temp.next == null){     // index == size - 1
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
            Node node = first;
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
        sb.append("{");
        Node temp = first;
        for (int i = 0; i < size; i++) {
            if (i != 0){
                sb.append(",");
            }
            sb.append(temp);
            temp = temp.next;
        }
        sb.append("}");
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
