package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Solution {

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
        for (int element : a
        ) {
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

    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> listTemp1 = new ArrayList<>();
        listTemp1.add(11);
        listTemp1.add(2);
        listTemp1.add(4);
        matrix.add(listTemp1);

        List<Integer> listTemp2 = new ArrayList<>();
        listTemp2.add(4);
        listTemp2.add(5);
        listTemp2.add(6);
        matrix.add(listTemp2);

        List<Integer> listTemp3 = new ArrayList<>();
        listTemp3.add(10);
        listTemp3.add(8);
        listTemp3.add(-12);
        matrix.add(listTemp3);

        System.out.println(diagonalDifference(matrix));
    }
}
