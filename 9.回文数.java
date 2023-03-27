/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        // 方法论
        // 负数首先排除，然后查看这个数有多少位，除以2，调换位置
        if (x < 0) {
            return false;
        }
        // 0 和 个位数一定是
        if (x == 0 || (x / 10) == 0) {
            return true;
        }

        // 判断多少位
        String xStr = String.valueOf(x);
        int length = xStr.length();

        // 反转数字
        long newX = 0;
        String newXStr = "";
        for (int index = (length - 1); (index > 0 || index == 0); index--) {
            char temp = xStr.charAt(index);
            newXStr += temp;
        }
        newX = Long.parseLong(newXStr);

        return x == newX;

    }
}
// @lc code=end

