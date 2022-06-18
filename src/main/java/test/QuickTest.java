package test;

import com.example.demo.entity.ListNode;
import com.example.demo.util.SearchUtil;
import com.example.demo.util.SortUtil;

import java.util.*;

public class QuickTest {

    public static void main(String[] args) {
//        int[] nums={9,3,7,5,8,2,1,6,4,0};
//        int[] sortedNums=SortUtil.quickSort(nums);
//        System.out.println(Arrays.toString(sortedNums));
//        System.out.println(SearchUtil.binerySearch(sortedNums, 3));

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        QuickTest quickTest = new QuickTest();
        System.out.println(quickTest.removeDuplicates(nums));

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next=new ListNode(0);
        head.next.next.next=new ListNode(-4);
        head.next.next.next.next=head.next;
        quickTest.detectCycle(head);

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

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                break;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return head;
    }

}
