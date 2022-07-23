package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.ListNode;
import com.example.demo.util.ListNodeUtil;
import org.springframework.data.util.Pair;

import java.util.*;

/*
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
* */

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

//        System.out.println(quickTest.getZipped("2abcc"));

//        List<Pair<Integer, Integer>> inputDirs = new ArrayList<>();
//        inputDirs.add(Pair.of(8, 6));
//        inputDirs.add(Pair.of(10, 8));
//        inputDirs.add(Pair.of(6, 0));
//        inputDirs.add(Pair.of(20, 8));
//        inputDirs.add(Pair.of(2, 6));
//        System.out.println(quickTest.getLeftDir(inputDirs, 8));

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(5);
        list.add(3);
        System.out.println(findMedian(list));
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int len = arr.size();
        int middleIndex = 0;
        if (len % 2 == 0) {
            middleIndex = len / 2 + 1;
        } else {
            middleIndex = len / 2;
        }

        return arr.get(middleIndex);
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int max = scores.get(0);
        int min = scores.get(0);
        int breakMaxCount = 0;
        int breakMinCount = 0;
        for (Integer score : scores) {
            if (score > max) {
                max = score;
                breakMaxCount++;
            }
            if (score < min) {
                min = score;
                breakMinCount++;
            }
        }
        List<Integer> results = new ArrayList<>();
        results.add(breakMaxCount);
        results.add(breakMinCount);
        return results;
    }

    public static String timeConversion(String s) {
        // Write your code here
        String hourString = s.substring(0, 2);
        int hourNumber = Integer.parseInt(hourString);

        String PA = s.substring(s.length() - 2, s.length());
        if (PA.compareTo("PM") == 0) {
            if (hourNumber == 12) {
                ;
            } else {
                hourNumber += 12;
            }
            hourNumber = hourNumber % 24;
        } else if (PA.compareTo("AM") == 0) {
            hourNumber = hourNumber % 12;
        }

        String leftTime = s.substring(2, s.length() - 2);
        StringBuilder sb = new StringBuilder();
        String newHour = String.format("%02d", hourNumber);
        sb.append(newHour);
        sb.append(leftTime);
        return sb.toString();
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = head;
        int size = ListNodeUtil.size(head);
        int[] array = new int[size];

        int serialNum = 1;
        while (head != null) {
            array[size - serialNum] = head.val;
            head = head.next;
            serialNum++;
        }

        ListNode result = ListNodeUtil.initListNode(array);
        return result;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        ListNode node = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }

            node = node.next;
        }

        while ((node != null) && (list1 != null || list2 != null)) {
            if (list1 == null && list2 != null) {
                node.next = list2;
                list2 = list2.next;
            }
            if (list1 != null && list2 == null) {
                node.next = list1;
                list1 = list1.next;
            }

            node = node.next;
        }

        return dummyNode.next;
    }

    public int[] twoSum(int[] nums, int target) {
        int firstIndex = -1;
        int lastIndex = 0;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{firstIndex, lastIndex};
    }

    public void pareMyObject(String input, List<JSONObject> output) {
        JSONObject object = JSON.parseObject(input);
        System.out.println(object.toString());
        output.add(new JSONObject(object));
    }


    // 2,3,5
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(candidates);

        for (int j = 0; j < candidates.length; j++) {

            List<Integer> tempExternal = new ArrayList<>();
            tempExternal.add(candidates[j]);
            if (getSum(tempExternal) == target) {
                results.add(new ArrayList<>(tempExternal));
                break;
            }

            List<Integer> tempInternal = new ArrayList<>();

            for (int i = j; i < candidates.length; ) {
                int current = candidates[i];
                tempInternal.add(current);

                int sum = getSum(tempExternal) + getSum(tempInternal);
                if (sum < target) {
                } else if (sum > target) {
                    int next = 0;
                    if (i < candidates.length - 1) {
                        next = candidates[i + 1];
                    }
                    while (getSum(tempExternal) + getSum(tempInternal) + next > target && !tempInternal.isEmpty()) {
                        tempInternal.remove(tempInternal.size() - 1);
                    }
                    i++;
                } else {
                    List<Integer> temp = new ArrayList<>(tempExternal);
                    temp.addAll(new ArrayList<>(tempInternal));
                    results.add(new ArrayList<>(temp));

                    int next = 0;
                    if (i < candidates.length - 1) {
                        next = candidates[i + 1];
                    }
                    while (getSum(tempExternal) + getSum(tempInternal) + next != target && !tempInternal.isEmpty()) {
                        tempInternal.remove(tempInternal.size() - 1);
                    }
                    i++;
                }

            }

        }
        return results;
    }

    private int getSum(List<Integer> input) {
        int sum = 0;
        for (Integer value : input) {
            sum += value;
        }
        return sum;
    }

    public int getNumber(StringBuilder sb, int lastIndex) {
        int number = 0;
        StringBuilder sbTemp = new StringBuilder();
        for (int i = lastIndex - 1; i >= 0; i--) {
            char current = sb.charAt(i);
            if (current >= '0' && current <= '9') {
                sbTemp.append(current);
            } else {
                break;
            }
        }
        sbTemp.reverse();
        number = Integer.parseInt(sbTemp.toString());
        return number;
    }

    public int getNumberSpace(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            ++count;
        }
        return count;
    }

    public String decodeString(String s) {
        int len = s.length();

        StringBuilder sb = new StringBuilder(s);
        while (true) {
            int lastIndex = sb.lastIndexOf("[");
            if (lastIndex == -1) {
                break;
            }
            int matchedIndex = sb.indexOf("]", lastIndex);
            String subtring = sb.substring(lastIndex + 1, matchedIndex);
            int number = getNumber(sb, lastIndex);
            StringBuilder sbTemp = new StringBuilder();
            for (int i = 0; i < number; i++) {
                sbTemp.append(subtring);
            }
            sb = sb.delete(lastIndex - getNumberSpace(number), matchedIndex + 1);
            sb = sb.insert(lastIndex - getNumberSpace(number), sbTemp);
        }

        return sb.toString();
    }

    Set<Integer> getLeftDir(List<Pair<Integer, Integer>> inputDirs, int deleteDir) {
        List<Pair<Integer, Integer>> leftResults = new ArrayList<>();
        Set<Integer> toBeDeleted = new HashSet<>();
        toBeDeleted.add(deleteDir);
        for (int i = 0; i < inputDirs.size(); i++) {
            Pair<Integer, Integer> pair = inputDirs.get(i);
            if (pair.getSecond() == deleteDir) {
                toBeDeleted.add(pair.getFirst());
            }
        }

        for (int i = 0; i < inputDirs.size(); i++) {
            for (int j = 0; j < inputDirs.size(); j++) {
                Pair<Integer, Integer> pair = inputDirs.get(j);
                if (toBeDeleted.contains(pair.getSecond())) {
                    toBeDeleted.add(pair.getFirst());
                }
            }
        }

        for (int i = 0; i < inputDirs.size(); i++) {
            Pair<Integer, Integer> pair = inputDirs.get(i);
            if (toBeDeleted.contains(pair.getFirst()) && pair.getSecond() != deleteDir) {
                leftResults.add(Pair.of(Integer.MIN_VALUE, pair.getSecond()));
            } else if (toBeDeleted.contains(pair.getSecond())) {
                continue;
            } else if (pair.getSecond() == 0) {
                leftResults.add(Pair.of(pair.getFirst(), 0));
            } else {
                leftResults.add(Pair.of(pair.getFirst(), pair.getSecond()));
            }
        }

        Set<Integer> leftDir = new HashSet<>();
        for (int i = 0; i < leftResults.size(); i++) {
            Pair<Integer, Integer> pair = leftResults.get(i);
            if (pair.getFirst() == Integer.MIN_VALUE) {
                leftDir.add(pair.getSecond());
            } else if (pair.getSecond() == 0) {
                leftDir.add(pair.getFirst());
            } else {
                leftDir.add(pair.getFirst());
                leftDir.add(pair.getSecond());
            }
        }

        return leftDir;
    }

    public boolean isNumber(char input) {
        return input >= '0' && input <= '9';
    }

    public boolean isAlphabet(char input) {
        return input >= 'a' && input <= 'z';
    }

    public boolean isLegal(char input) {
        if (isNumber(input)) {
            return true;
        } else return isAlphabet(input);
    }

    public String getZipped(String strInput) {
        String error = "!error";

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

                int j = i + 1;
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
                for (int k = 0; k < charNumber - 1; k++) {
                    unzipped.append(nextAlphabet);
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
