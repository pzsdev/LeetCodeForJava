/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 * 
 * 就是两个字符串根据 # 来删除前一个元素，然后来做比较
 * 重点就是这个删除操作
 * 
 * 头脑风暴：
 * 1、最直接的是两个 for 循环，每个 for 循环两个指针，因为有 # 时是往前删，
 *    所以顺序循环会破坏索引，故最后往前去循环
 * 
 * 额，看了编程随想录题解，还是思路差了一点点，String 没有什么能直接删指定位置的方法，StringBuilder 才有。
 * 对基础 API 还不熟啊～
 * 
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder ssb = new StringBuilder(); // 模拟栈
        StringBuilder tsb = new StringBuilder(); // 模拟栈

        // 分别处理两个 String
        for (char c : s.toCharArray()) {
            if (c != '#') {
                ssb.append(c);
            } else if (ssb.length() > 0) { // 栈非空才能弹栈（走到这的条件是 c == '#'）
                ssb.deleteCharAt(ssb.length() - 1); // 模拟弹栈
            }
        }

        for (char c : t.toCharArray()) {
            if (c != '#') {
                tsb.append(c);
            } else if (tsb.length() > 0) {
                tsb.deleteCharAt(tsb.length() - 1);
            }
        }

        return ssb.toString().equals(tsb.toString());
    }
}
// @lc code=end

