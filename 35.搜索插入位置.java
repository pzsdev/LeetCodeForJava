/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        // 想清楚了知道要用二分查找，但是写不出来。。

        // 没有明确的列出可以分几种情况
        // 四种情况
        // - 目标值在数组所有元素之前
        // - 目标值等于数组中某一元素
        // - 目标值插入数组中的位置
        // - 目标值在数组所有元素之后

        int n = nums.length;

        // 定义 target 在左闭右闭的区间，[left, right]
        int left = 0;
        int right = n - 1; 

        while (left <= right) { // 当 left=right，区间[left, right] 依然有效
            int middle = left + ((right - left) / 2); // 防止溢出
            if (nums[middle] > target) {
                right = middle - 1; // target 在左区间，所以[left, mid - 1]
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间，所以 [mid + 1, right]
            } else {
                // 1. 目标值等于数组中某一元素，return mid
                return middle;
            }
        }
        // 2. 目标值在数组所有元素之前；3. 目标值插入数组中；4. 目标值在数组所有元素之后
        return right + 1;
    }
}
// @lc code=end

