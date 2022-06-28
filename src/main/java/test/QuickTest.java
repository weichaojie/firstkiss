package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

        int[] nums = {2, 7, 6, 3, 5, 1};
//        System.out.println(quickTest.combinationSum(nums, 9));

        List<JSONObject> myJSonList = new ArrayList<>();
        quickTest.pareMyObject("{a:1,b:2}", myJSonList);
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
