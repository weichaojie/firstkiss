package test;

import com.example.demo.util.SortUtil;

import java.util.Arrays;

public class QuickTest {

    public static void main(String[] args) {
        int[] nums={9,3,7,5,8,2,1,6,4,0};
        System.out.println(Arrays.toString(SortUtil.quickSort(nums)));
    }
}
