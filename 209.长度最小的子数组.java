/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口思想 from carl

        int left = 0; // 窗口左边边界
        int sum = 0; // 连续子数组的和
        int result = Integer.MAX_VALUE; // 连续子数组元素个数，先设置为一个大值，方便中比较取最小值

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                result = Math.min(result, right - left + 1); // 更新最小数量
                sum -= nums[left++]; // 为下一次计算，滑动左边窗口（left++），同时剔除左边元素的值
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
// @lc code=end

