/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 边界条件
        if (strs.length == 1) {
            return strs[0];
        }

        // 正常条件
        // 假设第一个元素就是最长公共前缀，然后去一个一个判断，
        // 不是的话就缩短一个字符
        String pre = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }
}
// @lc code=end

