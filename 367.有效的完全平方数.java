
/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;

        while (left < right) {
            int mid = left + (right - left) / 2;

            long x = (long)mid * mid;
            if (x < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left * left == num;
    }
}
// @lc code=end

