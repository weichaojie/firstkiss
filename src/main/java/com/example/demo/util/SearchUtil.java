package com.example.demo.util;

public class SearchUtil {
    public static int binerySearch(int[] sortedNums, int target) {
        int left = 0;
        int right = sortedNums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = sortedNums[mid];
            if (midValue > target) {
                right = mid - 1;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
