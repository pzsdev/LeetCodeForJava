/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        // 哪个位置的值和 val 相等，移除了（就得把这个位置的值用后面的填充上）
        // 也是双指针，一个 cur，当前判断位置，一个 最后返回位置 returnIndex
        int returnIndex = 0;
        if (nums.length == 0) {
            return returnIndex;
        }

        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != val) {
                nums[returnIndex++] = nums[cur];
            }
        }
        return returnIndex;
    }
}
// @lc code=end

