package com.wz.queue.v2;

/**
 * @author 隔壁老王
 * @create 2020-05-15 17:07
 * @微信公众号 隔壁老王说Java
 * @description 基于数组实现的的循环队列
 */
public class CircularQueue<E> implements Queue<E> {

    private E[] data;

    /**
     * front: 队头，指向第一个元素
     * rear: 队尾，指向最后一个元素的下一个位置
     */
    private int front,rear;

    // 元素个数
    private int size;

    public CircularQueue(int capacity) {
        // 加一的原因是rear指向最后一个元素的下一个位置，会造成一个空间的浪费，因此需要装载capacity个元素时，需要加1
        this.data = (E[]) new Object[capacity + 1];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public CircularQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        // 判断队列是否满：满的条件为 (rear+1) % data.length == front
        if((rear+1) % data.length == front){
            resize((data.length-1) * 2);
        }
        data[rear] = e;
        rear = (rear + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("队列为空,无法出队");
        }
        E temp = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size == (data.length-1) / 4 && (data.length-1) / 2 != 0){
            // 缩容
            resize((data.length-1) / 2);
        }
        return temp;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // 当front==rear时数组为空，队列为空
        return front == rear;
    }

    // 扩容方法
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for(int i = 0; i < size; i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        rear = size;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append("队列: ");
        res.append("队头 [");
        for(int i = front ; i != rear ; i = (i + 1) % data.length){
            res.append(data[i]);
            // 判断是否为最后一个元素
            if((i + 1) % data.length != rear) {
                res.append(", ");
            }
        }
        res.append("] 队尾");
        return res.toString();
    }
}
