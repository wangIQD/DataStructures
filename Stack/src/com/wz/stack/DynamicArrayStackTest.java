package com.wz.stack;

/**
 * @author 隔壁老王
 * @create 2020-05-14 17:13
 * @微信公众号 隔壁老王说Java
 * @description
 */
public class DynamicArrayStackTest {
    public static void main(String[] args) {
        DynamicArrayStack<Integer> stack = new DynamicArrayStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        System.out.println("栈中元素个数：" + stack.getSize());
        System.out.println("栈顶元素：" + stack.peek());
    }
}
