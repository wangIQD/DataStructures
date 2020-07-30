package com.wz.dynamicarray;

import com.wz.dynamicarray.v4.DynamicArray;

/**
 * @author 隔壁老王
 * @create 2020-05-12 17:44
 * @description
 */
//动态数组测试类
public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>();
        for(int i = 0 ; i < 10 ; i ++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
