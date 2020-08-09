package com.wz.linkedlist.v4;

/**
 * @author 隔壁老王
 * @create 2020-07-29 7:50
 * @微信公众号 隔壁老王说Java
 * @description 约瑟夫问题，新增一个成员变量，三个方法：current：用于指向某个节点，reset()：让current指向头结点first，
 * next()：让current往后走一步，也就是current = current.next，remove()：删除current指向的节点，删除成功后让current指向下一个节点
 * 也可以使用单向循环链表实现约瑟夫问题
 */

/**
 * 据说著名犹太历史学家Josephus有过以下的故事：在罗马人占领乔塔帕特后，39 个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人
 * 决定宁愿死也不要被敌人抓到，于是决定了一个自杀方式，41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀，然后
 * 再由下一个重新报数，直到所有人都自杀身亡为止。然而Josephus 和他的朋友并不想遵从。首先从一个人开始，越过k-2个人（因为第一个人
 * 已经被越过），并杀掉第k个人。接着，再越过k-1个人，并杀掉第k个人。这个过程沿着圆圈一直进行，直到最终只剩下一个人留下，这个人就
 * 可以继续活着。问题是，给定了和，一开始要站在什么地方才能避免被处决？Josephus要他的朋友先假装遵从，他将朋友与自己安排在第16个
 * 与第31个位置，于是逃过了这场死亡游戏。
 */
public class JosephusProblem<E> {

    // 头结点，指向链表第一个节点
    private Node first;
    // 尾结点，指向链表最后一个节点
    private Node last;
    // current，用于指向某个节点
    private Node current;
    // 元素个数
    private int size;

    // 添加元素
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("索引不符合要求");
        }
        if (index == size){ // 往最后面添加元素
            Node oldLast = last;
            last = new Node(e, oldLast, first);
            if (oldLast == null){   // 这是链表添加的第一个元素
                first = last;
                first.next = first;
                first.prev = first;
            }else {
                oldLast.next = last;
                first.prev = last;
            }
        }else {
            Node next = get(index);
            Node prev = next.prev;
            Node node = new Node(e,prev,next);
            next.prev = node;
            prev.next = node;

            if (next == first){     // index == 0
                first = node;
            }
        }
        size++;
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

    // 删除current指向的节点，删除成功后让current指向下一个节点
    public E remove(){
        if (current == null){
            return null;
        }
        Node next = current.next;
        E e = remove(current);
        if (size == 0){
            current = null;
        }else {
            current = next;
        }
        return e;
    }
    private E remove(Node node){
        if (size == 1){
            first = null;
            last = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            if (node == first){     // index == 0
                first = node.next;
            }

            if (node == last){      // index == size - 1
                last = node.prev;
            }
        }
        size--;
        return node.e;
    }

    // 让current指向头结点first
    public void reset(){
        current = first;
    }

    // 让current往后走一步，也就是current = current.next
    public E next(){
        if (current == null){
            return null;
        }
        current = current.next;
        return current.e;
    }

    // 判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
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
