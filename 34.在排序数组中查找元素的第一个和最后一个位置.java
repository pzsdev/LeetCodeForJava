/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 * 
 * 方法论，首先得把所有可能的情况都列出来，然后再根据情况，一个一个解答。
 * 
 * 寻找 target 在数组中的左右边界，有如下三种情况：
 * - 情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target 为 2，或者 target 为 6，此时返回 {-1, -1}；
 * - 情况二：target 在数组的范围中，且数组中不存在 target，例如数组 {3, 6, 7}, target 为 5，此时返回 {-1, -1}；
 * - 情况三：target 在数组范围中，且数组存在 target，例如数组 {3, 6, 7}，target 为 6，此时返回 {1, 1}。
 */

// @lc code=start
// class Solution34 {
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);

        // 情况一
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};

        // 情况三
        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder -1};

        // 情况二
        return new int[]{-1, -1};
    }

    // 二分查找，寻找 target 的右边界（不包括 target）
    // 如果 rightBorder 没有被赋值（即 target 在数组范围的左边，例如数组 {3, 3}，target 为 2），为情况一
    public int getRightBorder(int[] nums, int target) {
        System.out.println("method getRightBorder exec...");

        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("in loop start, the left is " + left + ", right is " + right + ", mind is " + mid);
            
            if (nums[mid] > target) {
                right = mid - 1; //target 在左区间，所以 {left, mid - 1}
            } else { // 当 nums[mid] == target 的时候，更新 left，这样才能得到 target 的右边界
                left = mid + 1;
                rightBorder = left;
            }
            System.out.println("in loop end, the left is " + left + ", right is " + right + "\n");
        }
        // 这里二分查找，没有找到一个就直接退出，而是要全部比较完，即 while 判断条件不成立时，才会退出循环
        return rightBorder;
    }

    public int getLeftBorder(int[] nums, int target) {
        System.out.println("method getLeftBorder exec...");

        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            System.out.println("in loop start, the left is " + left + ", right is " + right + ", mind is " + mid);

            if (nums[mid] >= target) {
                right = mid - 1;
                leftBorder = right;
            } else {
                left = mid + 1;
            }
            System.out.println("in loop end, the left is " + left + ", right is " + right + "\n");
        }

        return leftBorder;
    }
}
// @lc code=end

// class Main {
//     public static void main(String[] args) {
//         Solution34 solution34 = new Solution34();
//         int[] nums = {1, 2, 2, 2, 2, 5, 7, 8, 8, 9};

//         int target = 2;

//         int[] result = solution34.searchRange(nums, target);
//         System.out.println(result[0] + ", " + result[1]);
//     }
// }

