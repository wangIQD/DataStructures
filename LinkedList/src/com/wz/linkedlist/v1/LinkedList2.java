package com.wz.linkedlist.v1;

/**
 * @author 隔壁老王
 * @create 2020-05-16 15:02
 * @微信公众号 隔壁老王说Java
 * @description 实现单链表（不使用虚拟头结点）
 */
public class LinkedList2<E> {
    // 头结点，指向链表第一个节点
    private Node head;
    // 存储的节点个数
    private int size;

    // 添加元素（头插法）
    public void addFirst(E e){
        add(0,e);
    }

    // 添加元素，在某一位置添加元素
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("索引不符合要求");
        }

        if(index == 0){
            head = new Node(e, head);
        }else {
            Node prev = get(index - 1);
            prev.next = new Node(e, prev.next);
        }

        size++;
    }

    // 添加元素（尾插法）
    public void addLast(E e){
        add(size,e);
    }

    // 获取指定位置的节点
    public Node get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引不符合要求");
        }
        // 辅助节点，用于遍历。第一个元素的节点
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    // 获取第一个节点
    public Node getFirst(){
        return get(0);
    }

    // 获取最后一个节点
    public Node getLast(){
        return get(size - 1);
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
            head = head.next;
        }else {
            Node prev = get(index - 1);
            temp = prev.next;
            prev.next = temp.next;
        }

        size--;
        return temp.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从链表中删除指定元素
    public void removeE(E e){
        while (head != null && head.e.equals(e)){
            head = head.next;
        }
        Node prev = head;
        while(prev != null) {
            if(prev.next != null && prev.next.e.equals(e)) {
                prev.next = prev.next.next;
                size--;
            }else { // 必须加else语句，否则当两个相同的数据连续时会出现问题
                prev = prev.next;
            }
        }
    }

    // 查找链表中是否有元素e
    public boolean contains(E e){
        Node temp = head;
        while(temp != null){
            if(temp.e.equals(e)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
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
        for(Node temp = head ; temp != null ; temp = temp.next) {
            res.append(temp + "->");
        }
        res.append("NULL");

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
