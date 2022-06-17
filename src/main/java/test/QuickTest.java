package test;

import com.example.demo.util.SearchUtil;
import com.example.demo.util.SortUtil;

import java.util.Arrays;

public class QuickTest {

    public static void main(String[] args) {
        int[] nums={9,3,7,5,8,2,1,6,4,0};
        int[] sortedNums=SortUtil.quickSort(nums);
        System.out.println(Arrays.toString(sortedNums));
        System.out.println(SearchUtil.binerySearch(sortedNums, 3));
    }
}
