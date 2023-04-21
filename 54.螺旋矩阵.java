import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }

        int rows = matrix.length, columns = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int startx = 0, starty = 0; // 没圈的起始位置
        int loop = Math.min(rows, columns) / 2; // 循环次数
        int mid = Math.min(rows, columns) / 2;
        
        int offset = 1;
        int i, j;

        while (loop-- > 0) {
            i = startx;
            j = starty;

            for (j = starty; j < columns - offset; j++) {
                res.add(matrix[startx][j]);
            }

            for (i = startx; i < rows - offset; i++) {
                res.add(matrix[i][j]);
            }

            for (; j > starty; j--) {
                res.add(matrix[i][j]);
            }

            for (; i > startx; i--) {
                res.add(matrix[i][j]);
            }

            startx++;
            starty++;

            offset++;
        }

        if (Math.min(rows, columns) % 2 != 0) {
            if (rows > columns) {
                // 行数大于列数，最后留下一列
                for (int m = mid; m < mid + rows - columns + 1; m++) {
                    res.add(matrix[m][mid]);
                }
            } else {
                // 列数大于行，最后留下一行
                for (int n = mid; n < mid + columns - rows + 1; n++) {
                    res.add(matrix[mid][n]);
                }
            }
        }

        return res;
    }
}
// @lc code=end

