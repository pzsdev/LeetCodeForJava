/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n]; // 用二维数组定义结果，也就是返回的正方形矩阵

        int startx = 0, starty = 0; // 定义循环一个圈的起始位置
        int loop = n / 2; // 每个循环几圈，例如 n 为奇数 3，那么 loop = 1，只循环一圈，奇数时矩阵中间的值需要单独处理
        int mid = n / 2; // n 为奇数时，矩阵中间位置的索引，例如：n 为 3， 那么中间位置为 (1, 1)，5 为 (2, 2)
        int count = 1; // 用来给矩阵中每个空格赋值
        int offset = 1; // 需要控制每一条遍历的长度，每次循环右边界收缩一位
        int i, j; // 当前赋值位置索引

        while (loop-- > 0) {
            i = startx;
            j = starty;

            // 四个 for 循环模拟转一圈
            // 模拟最上面行，从左到右（左闭右开）
            for (j = starty; j < n - offset; j++) {
                res[startx][j] = count++;
            }

            // 模拟填充右列，从上到下（左闭右开）
            for (i = startx; i < n - offset; i++) {
                res[i][j] = count++;
            }

            // 模拟填充下行，从右到左（左闭右开）
            for (; j > starty; j--) {
                res[i][j] = count++;
            }

            // 模拟填充左行，从下到上（左闭右开）
            for (; i > startx; i--) {
                res[i][j] = count++;
            }

            // 第二圈开始的时候，起始位置要各自加 1。例如，第一圈起始位置为 (0, 0)，第二圈起始位置为 (1, 1)
            startx++;
            starty++;

            // offset 控制每一圈每一条边遍历的长度为 n - offset
            offset += 1;
        }

        // 如果 n 为奇数的话，单独给矩阵中间的位置赋值
        if (n % 2 == 1) {
            res[mid][mid] = count;
        }
        return res;
    }
}
// @lc code=end

