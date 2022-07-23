package com.example.demo.util;

import com.example.demo.entity.ListNode;

public class ListNodeUtil {

    public static ListNode initListNode(int[] arr) {
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        ListNode node = dummyNode;
        for (int element : arr) {
            node.next = new ListNode(element);
            node = node.next;
        }
        return dummyNode.next;
    }

    public static int size(ListNode list) {
        int size = 0;
        while (list != null) {
            list = list.next;
            size++;
        }
        return size;
    }
}
