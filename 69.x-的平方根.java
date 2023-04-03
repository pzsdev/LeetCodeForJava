/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 * 
 * 根据第一行，第一句话的非负整数，和提示，明确 x 的取值范围， 0 <= x <= 2^31 - 1；
 * 
 * 然后的问题是：怎么计算算术平方根？
 * 没头绪。看评论区。
 * 
 * 没有真正理解第二句话，
 * 不是让你去真写一个计算算术平方根的严格算法，
 * 而是不管用什么方法，只要输出一个算术平方根的整数部分的值，这里就可以用取巧的方法，
 * 而这正是做出这个题的关键。
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
// @lc code=end

