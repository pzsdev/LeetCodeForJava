import java.util.HashMap;

import javax.lang.model.element.Element;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        // 方法论：分两种情况，1特例时；2正常情况
        // 特例时，相近的右边减去左边，有六种情况
        // 正常情况，从右到左，根据映射逐个想加

        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int length = s.length();
        
        int result = 0;

        // 一个一个处理，处理一个的时候，判断下一个是否有关联，有的话两个一起处理，手动 i--，然后两个相减，再累加
        for (int i = length - 1; (i > 0 || i == 0); i--) {
            int j = i - 1;

            char firstRoman = s.charAt(i);
            if (j > 0 || j == 0) {
                char secondRoman = s.charAt(j);
    
                boolean specail = (firstRoman == 'V' && secondRoman == 'I') 
                || (firstRoman == 'X' && secondRoman == 'I') 

                || (firstRoman == 'L' && secondRoman == 'X') 
                || (firstRoman == 'C' && secondRoman == 'X') 

                || (firstRoman == 'D' && secondRoman == 'C') 
                || (firstRoman == 'M' && secondRoman == 'C'); 
    
                if (specail) {
                    int value = romanMap.get(firstRoman) - romanMap.get(secondRoman);
                    result += value;
                    i--;
                } else {
                    int value = romanMap.get(firstRoman);
                    result += value;
                }
            } else {
                int value = romanMap.get(firstRoman);
                result += value;
            }
        }

        return result;
    }
}
// @lc code=end

