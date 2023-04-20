import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        // 窗口中包含的字符和对应数量
        Map<Character, Integer> window = new HashMap<>();
        // 用一个 HashMap 保存 t 中元素及其对应个数
        Map<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char needChar = t.charAt(i);
            need.put(needChar, need.getOrDefault(needChar, 0) + 1);
        }

        int left = 0, right = 0; // 滑动窗口，左右边界
        int valid = 0;  // 记录窗口中满足 need 要求的字符同时满足该字符数量的次数

        int len = Integer.MAX_VALUE; // 记录最小字符串长度
        int start = 0; // 记录最小字符串的起始位置

        
        while (right < s.length()) {
            // 加入字符到 window 中
            char addChar = s.charAt(right); // 即将要加入 window 的字符
            window.put(addChar, window.getOrDefault(addChar, 0) + 1);
            right++; // 滑动右窗口（窗口扩大）

            // 如果这个字符是 need 中要求的字符，并且数量达到要求了，valid + 1
            if (need.containsKey(addChar) && window.get(addChar).equals(need.get(addChar))) {
                valid++;
            }

            // 当 window 中记录的字符和数量满足了 need 中要求的字符和数量，考虑收缩窗口
            while (valid == need.size()) {
                // 判断当前最小覆盖字符串是否比之前的最小覆盖字符串短
                if (right - left < len) {  // 注意：right 上面已经实施了 ++ 操作，所以这里长度不是 right - left + 1
                    // 更新最短覆盖时最小长度，更新最小覆盖起始位置
                    len = right - left;
                    start = left; 
                }

                char removeChar = s.charAt(left);

                if (need.containsKey(removeChar) && window.get(removeChar).equals(need.get(removeChar))) {
                    valid--;
                }

                window.put(removeChar, window.get(removeChar) - 1);
                // 窗口缩小
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
// @lc code=end

