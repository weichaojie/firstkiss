package test;

import com.example.demo.entity.ListNode;
import com.example.demo.util.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(63);
        list.add(25);
        list.add(73);
        list.add(1);
        list.add(98);
        list.add(73);
        list.add(56);
        list.add(84);
        list.add(86);
        list.add(57);
        list.add(16);
        list.add(83);
        list.add(8);
        list.add(25);
        list.add(81);
        list.add(56);
        list.add(9);
        list.add(53);
        list.add(98);
        list.add(67);
        list.add(99);
        list.add(12);
        list.add(83);
        list.add(89);
        list.add(80);
        list.add(91);
        list.add(39);
        list.add(86);
        list.add(76);
        list.add(85);
        list.add(74);
        list.add(39);
        list.add(25);
        list.add(90);
        list.add(59);
        list.add(10);
        list.add(94);
        list.add(32);
        list.add(44);
        list.add(3);
        list.add(89);
        list.add(30);
        list.add(27);
        list.add(79);
        list.add(46);
        list.add(96);
        list.add(27);
        list.add(32);
        list.add(18);
        list.add(21);
        list.add(92);
        list.add(69);
        list.add(81);
        list.add(40);
        list.add(40);
        list.add(34);
        list.add(68);
        list.add(78);
        list.add(24);
        list.add(87);
        list.add(42);
        list.add(69);
        list.add(23);
        list.add(41);
        list.add(78);
        list.add(22);
        list.add(6);
        list.add(90);
        list.add(99);
        list.add(89);
        list.add(50);
        list.add(30);
        list.add(20);
        list.add(1);
        list.add(43);
        list.add(3);
        list.add(70);
        list.add(95);
        list.add(33);
        list.add(46);
        list.add(44);
        list.add(9);
        list.add(69);
        list.add(48);
        list.add(33);
        list.add(60);
        list.add(65);
        list.add(16);
        list.add(82);
        list.add(67);
        list.add(61);
        list.add(32);
        list.add(21);
        list.add(79);
        list.add(75);
        list.add(75);
        list.add(13);
        list.add(87);
        list.add(70);
        list.add(33);
//        System.out.println(countingSort(list));

        ListNode head = new ListNode(7);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = head.next.next;

        ListNode node = detectCycle(head);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] counts = new int[arr.size()];
        for (Integer element : arr) {
            counts[element]++;
        }

        List<Integer> results = new ArrayList<>();
        for (int count : counts) {
            results.add(count);
        }
        return results;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here

        int left = 0;
        int offset = 0;
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> current = arr.get(i);
            for (int j = 0; j < current.size(); j++) {
                int element = current.get(offset);
                left += element;
                break;
            }
            offset++;
        }

        int right = 0;
        offset = 0;
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> current = arr.get(i);
            for (int j = 0; j < current.size(); j++) {
                right += current.get(current.size() - offset - 1);
                break;
            }
            offset++;
        }

        return Math.abs(left - right);
    }

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        int[] counts = new int[101];
        for (int element : a) {
            counts[element]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static List<String> splitObjects(String object) {
        List<String> results = new ArrayList<>();

        int len = object.length();
        List<Integer> indexList = new ArrayList<>();
        indexList.add(0);
        for (int i = 0; i < len; i++) {
            char current = object.charAt(i);
            if (Character.isUpperCase(current)) {
                indexList.add(i);
            }
        }
        indexList.add(len);
        for (int i = 0; i < indexList.size() - 1; i++) {
            int current = indexList.get(i);
            int next = indexList.get(i + 1);
            String temp = object.substring(current, next);
            results.add(temp);
        }
        return results;
    }

    public static void dispose(String input) {
        char command = input.charAt(0);
        char type = input.charAt(2);
        String object = input.substring(4, input.length());

        StringBuilder sb = new StringBuilder();
        if (command == 'S') {

            if (type == 'M') {
                // 去掉最后面的两个()
                object = object.substring(0, object.length() - 2);
            } else if (type == 'C' || type == 'V') {
                ;
            }
            List<String> objects = splitObjects(object);
            for (String current : objects) {
                if (!current.isEmpty()) {
                    current = current.toLowerCase(Locale.ROOT);
                    sb.append(current);
                    sb.append(" ");
                }
            }
            sb.delete(sb.length() - 1, sb.length());


        } else if (command == 'C') {
            String[] objects = object.split(" ");

            if (type == 'M') {
                int i = 0;
                for (String current : objects) {
                    // 第一个方法不将首字母大写
                    if (i != 0) {
                        String temp = current.substring(0, 1).toUpperCase() + current.substring(1);
                        sb.append(temp);
                    } else {
                        sb.append(current);
                    }
                    i++;
                }

                // 对方法的最后增加（）
                sb.append("()");
            } else if (type == 'C') {
                // 每一个方法的首字母都要大写
                for (String current : objects) {
                    String temp = current.substring(0, 1).toUpperCase() + current.substring(1);
                    sb.append(temp);
                }
            } else if (type == 'V') {
                int i = 0;
                for (String current : objects) {
                    // 第一个方法不将首字母大写
                    if (i != 0) {
                        String temp = current.substring(0, 1).toUpperCase() + current.substring(1);
                        sb.append(temp);
                    } else {
                        sb.append(current);
                    }
                    i++;
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static ListNode middleNode(ListNode head) {
        int size = ListNodeUtil.size(head);
        int middle = size / 2;
        int index = 0;
        while (head != null) {
            if (index == middle) {
                return head;
            }
            index++;
            head = head.next;
        }
        return null;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tortoise = head;
        ListNode hare = head;

        while (true) {

            tortoise = tortoise.next;
            hare = hare.next;
            if (hare != null) {
                hare = hare.next;
            }
            if (tortoise == null || hare == null) {
                return null;
            }
            if (hare == tortoise) {
                break;
            }
        }

        hare = head;
        while (hare != tortoise) {
            hare = hare.next;
            tortoise = tortoise.next;
        }

        return hare;
    }

}
