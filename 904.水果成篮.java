import java.sql.RowId;

/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        // 统计 相邻的两个数为一组，出现的次数最大的情况
        // 求只包含两种元素的最长连续子序列
        int firstIndex = 0, secondIndex = 0, maxLength = 0;

        int firstBasket = fruits[firstIndex], secondBasket = fruits[secondIndex];

        while (secondIndex < fruits.length) {
            if (fruits[secondIndex] == firstBasket || fruits[secondIndex] == secondBasket) {
                // 判断下一个属于哪个篮子
                // 是的话，更新一下最长连续子序列长度
                maxLength = Math.max(maxLength, secondIndex - firstIndex + 1);
                secondIndex++;
            } else {
                // 如果遇到第三种，把慢指针移动到快指针前一步，该步的水果种类必然不同于快指针，此时慢指针慢慢回退齐所有的连续同类。
                firstIndex = secondIndex - 1;
                firstBasket = fruits[firstIndex];

                while (firstIndex >= 1 && fruits[firstIndex - 1] == firstBasket) {
                    firstIndex--;
                }

                secondBasket = fruits[secondIndex];
                maxLength = Math.max(maxLength, secondIndex - firstIndex + 1);
            }
        }

        return maxLength;
    }
}
// @lc code=end

