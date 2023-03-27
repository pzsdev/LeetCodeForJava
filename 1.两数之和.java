import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = null;
        int length = nums.length;
        for (int first = 0; first < (length - 1); first++) {
            for (int second = (first + 1); second < length; second++) {
                int sum = nums[first] + nums[second];
                if (sum == target) {
                    result = new int[]{first, second};
                    return result;
                }
            }
        }
        return result;
    }
}
// @lc code=end

// class Main {
//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         int[] nums = {2, 7, 11, 15};
//         int target = 9;
//         int[] result = solution.twoSum(nums, target);
//         System.out.println("the result is " + result[0] + ", " + result[1]);
//     }
// }