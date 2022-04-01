package com.wz.stack.v1;

/**
 * @author 隔壁老王
 * @create 2020-04-01
 * @微信公众号 隔壁老王说Java
 * @description 基于动态数组实现的栈的测试
 */
public class DynamicArrayStackTest {
    public static void main(String[] args) {
        DynamicArrayStack<Integer> stack = new DynamicArrayStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
        }
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println("栈中元素个数：" + stack.getSize());
        System.out.println("栈顶元素：" + stack.peek());

        while(!stack.isEmpty()){
            Integer e = stack.pop();
            System.out.println("出栈元素：" + e);
        }
    }
}
