import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length;

        int i = end - 1;
        int[] a = new int[end--];

        // 双指针方法，题目说明为 非递减顺序，说明是可重复的有序数组，两边的值的平方一定是最大的
        // 依次比较两边值的平方，大的放到新数据的最后位置，被拿掉的一边索引往中间靠一位
        while (end >= start) {
            a[i--] = nums[start] * nums[start] >= nums[end] * nums[end] ? nums[start] * nums[start++] : nums[end] * nums[end--];
        }
        return a;
    }
}
// @lc code=end

