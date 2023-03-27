/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // 一下子想不清楚，就多分几步想
        // 一个指针，当前判断位置，标明现在判断到哪个位置了；一个指针，最后位置指针，标明要输出的数组末尾索引
        // 当前判断位置和后一个比较，相同则，最后位置指针不动，当前位置向后移动一位
        // 如果不同，则最后位置指针向后移动一位，同时这个不同位置的值，写到最后的位置，判断指针也向后移动一位
        int returnIndex = 1;
        int length = nums.length;
        if (length == 1) {
            return returnIndex;
        }

        for (int curIndex = 0; curIndex < length - 1; curIndex++) {
            if (nums[curIndex] == nums[curIndex + 1]) {
                continue;
            } else {
                nums[returnIndex] = nums[curIndex + 1];
                returnIndex++;
            }
        }
        return returnIndex;
    }
}
// @lc code=end

