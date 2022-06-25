package test;

import jdk.internal.net.http.common.Pair;

import java.util.*;

public class QuickTest {

    public static void main(String[] args) {
        QuickTest quickTest = new QuickTest();
//        int[] nums={9,3,7,5,8,2,1,6,4,0};
//        int[] sortedNums=SortUtil.quickSort(nums);
//        System.out.println(Arrays.toString(sortedNums));
//        System.out.println(SearchUtil.binerySearch(sortedNums, 3));

//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        System.out.println(quickTest.removeDuplicates(nums));
//
//        ListNode head = new ListNode(3);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(-4);
//        head.next.next.next.next = head.next;

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = head;

//        quickTest.detectCycle(head);

//        String s = "cars";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("car");
//        wordDict.add("ca");
//        wordDict.add("rs");
//        System.out.println(quickTest.wordBreak(s, wordDict));

//        int[] nums = {0,1,2};
//        System.out.println(quickTest.subsets(nums));
        System.out.println(quickTest.findMatchedString("abc", "qcwab"));

    }

    public boolean isNumber(char input) {
        if (input >= '0' && input <= '9') {
            return true;
        }
        return false;
    }

    public boolean isAlphabet(char input) {
        if (input >= 'a' && input <= 'z') {
            return true;
        }
        return false;
    }

    public boolean isLegal(char input) {
        if (isNumber(input)) {
            return true;
        } else if (isAlphabet(input)) {
            return true;
        }
        return false;
    }

    public String getZipped(String strInput) {
        String error = new String("!error");

        // 排除特殊字符串
        for (int i = 0; i < strInput.length(); i++) {
            if (!isLegal(strInput.charAt(i))) {
                return error;
            }
        }

        StringBuilder unzipped = new StringBuilder();
        for (int i = 0; i < strInput.length(); ) {
            char current = strInput.charAt(i);
            if (isAlphabet(current)) {
                unzipped.append(current);
                i++;
            } else if (isNumber(current)) {

                char nextAlphabet = '@';
                StringBuilder sb = new StringBuilder();
                sb.append(current);

                int j = i;
                for (; j < strInput.length(); j++) {
                    if (isAlphabet(strInput.charAt(j))) {
                        nextAlphabet = strInput.charAt(j);
                        break;
                    } else if (isNumber(strInput.charAt(j))) {
                        sb.append(strInput.charAt(j));
                    }

                }
                i = j;
                if (nextAlphabet == '@') {
                    return error;
                }
                int charNumber = Integer.parseInt(sb.toString());
                if (charNumber <= 2) {
                    return error;
                }
            }
        }


        return unzipped.toString();
    }

    public int[] getStringEncoded(String strInput) {
        int[] results = new int[256];
        int len = strInput.length();
        for (int i = 0; i < len; i++) {
            results[strInput.charAt(i) - 'a']++;
        }
        return results;
    }

    public int findMatchedString(String strSrc, String strDest) {
        int[] srcEncoded = getStringEncoded(strSrc);
        int lenSrc = strSrc.length();
        for (int i = 0; i <= strDest.length() - lenSrc; i++) {
            String currentStr = strDest.substring(i, i + lenSrc);
            int[] currentEncoded = getStringEncoded(currentStr);
            if (Arrays.equals(currentEncoded, srcEncoded)) {
                return i;
            }
        }
        return -1;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        results.add(new LinkedList<>());
        for (int num : nums) {
            List<List<Integer>> temp = new LinkedList<>();
            for (int i = 0; i < results.size(); i++) {
                temp.add(new LinkedList<>(results.get(i)));
            }

            for (int i = 0; i < temp.size(); i++) {
                List<Integer> subList = temp.get(i);
                subList.add(num);
                results.add(subList);
            }

        }
        return results;
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        Collections.sort(wordDict);
        StringBuilder sb = new StringBuilder(s);
        List<String> strings = new ArrayList<>();

        for (String word : wordDict) {
            while (sb.indexOf(word) != -1) {
                int index = sb.indexOf(word);
                if (index != 0 && index != -1) {
                    String[] strs = sb.toString().split(word);
                    for (String str : strs) {
                        strings.add(str);
                    }
                    sb = sb.delete(index, index + word.length());
                } else if (index == 0) {
                    sb = sb.delete(index, word.length());
                }
            }
        }
        if (sb.length() != 0) {
            return false;
        }

        for (String str : strings) {
            if (!wordBreak(str, wordDict)) {
                return false;
            }
        }

        return true;
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
        }
        Object[] temp = set.toArray();
        for (int i = 0; i < temp.length; i++) {
            nums[i] = (int) temp[i];
        }

        return temp.length;
    }

}
