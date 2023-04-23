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

        // 行和列
        int rows = matrix.length, columns = matrix[0].length;
        // 返回对象
        List<Integer> res = new ArrayList<>();

        int startx = 0, starty = 0; // 没圈的起始位置

        int loop = Math.min(rows, columns) / 2; // 循环次数
        
        // 如果 Math.min(rows, coloums) 为偶数，则不需要最后单独考虑矩阵中间位置的赋值
        // 如果 Math.min(rows, coloums) 为奇数，则矩阵最中间位置不只是[mid][mid]，
        // 而是会留下来一个特殊的中间行或者中间列，具体是中间行还是中间列，看 rows 和 colums 的大小，
        // 如果 rows > columns ，则是中间列，相反，则是中间行.
        // 这个不好理解，通过画图去理解
        int mid = Math.min(rows, columns) / 2;
        
        int offset = 1; // 遵循左闭右开的原则每条边，都留最后一个放到下一个边去处理，每个圈的留几个就是这个 offset
        int i, j;

        while (loop-- > 0) {
            i = startx;
            j = starty;

            // 上边，左闭右开
            for (j = starty; j < columns - offset; j++) {
                res.add(matrix[startx][j]);
            }

            // 
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

        //
        if (Math.min(rows, columns) % 2 != 0) {
            if (rows > columns) {
                // 行数大于列数，最后留下一列
                for (int m = mid; m < mid + rows - columns + 1; m++) {
                    // 列，则第二个位置固定
                    res.add(matrix[m][mid]);
                }
            } else {
                // 列数大于行，最后留下一行
                for (int n = mid; n < mid + columns - rows + 1; n++) {
                    // 行，则第一个位置固定
                    res.add(matrix[mid][n]);
                }
            }
        }

        return res;
    }
}
// @lc code=end

