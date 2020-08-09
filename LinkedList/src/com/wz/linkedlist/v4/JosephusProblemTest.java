package com.wz.linkedlist.v4;

/**
 * @author 隔壁老王
 * @create 2020-07-29 9:29
 * @微信公众号 隔壁老王说Java
 * @description 约瑟夫问题测试，也可以使用单向循环链表实现约瑟夫问题
 */

/**
 * 据说著名犹太历史学家Josephus有过以下的故事：在罗马人占领乔塔帕特后，39 个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人
 * 决定宁愿死也不要被敌人抓到，于是决定了一个自杀方式，41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀，然后
 * 再由下一个重新报数，直到所有人都自杀身亡为止。然而Josephus 和他的朋友并不想遵从。首先从一个人开始，越过k-2个人（因为第一个人
 * 已经被越过），并杀掉第k个人。接着，再越过k-1个人，并杀掉第k个人。这个过程沿着圆圈一直进行，直到最终只剩下一个人留下，这个人就
 * 可以继续活着。问题是，给定了和，一开始要站在什么地方才能避免被处决？Josephus要他的朋友先假装遵从，他将朋友与自己安排在第16个
 * 与第31个位置，于是逃过了这场死亡游戏。
 */
public class JosephusProblemTest {
    public static void main(String[] args) {
        JosephusProblem<Integer> list = new JosephusProblem<>();
        for (int i = 1; i <= 41; i++){
            list.add(list.getSize(),i);
        }
        // 指向头结点（指向1）
        list.reset();

        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
    }
}
