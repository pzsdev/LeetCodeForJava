import javax.lang.model.element.Element;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        // 把字符串转为单个的字符数组，遍历；
        // 从左至右，依次判断，有左括号，则栈中压入一个相应的有括号；
        // 最后一个判断，如果都是配对的，在没有到达最后一个元素前，栈中都是有元素的 stack.isEmpty() == false；
        // 此时栈中的都是数组接下来需要的配对的右括号，字符数组接下来都要和栈中弹出的元素相等才会括号配对成功；
        // 到最后，括号都是配对的，则栈中元素都弹出了，所以栈为空
        for (char c: s.toCharArray()){
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

// class Main {
//     public static void main(String[] args) {
//         // Solution1 solution1 = new Solution1();
//         // String s = "()[]{}";
//         // boolean valid = solution1.isValid(s);
//         // System.out.println(valid);
//         String s = "()[]{}";
//         s = s.replaceAll("\\(\\)", "");
//         s = s.replaceAll("\\[\\]", "");
//         s = s.replaceAll("\\{\\}", "");
//         System.out.println("the s is " + s);
//     }
// }