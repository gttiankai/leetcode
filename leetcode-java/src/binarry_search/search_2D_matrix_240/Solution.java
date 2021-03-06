/**
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 *
 * This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 * */

package binarry_search.search_2D_matrix_240;



public class Solution {
    /**
     * 这个题目可以采用最笨的方法,直接遍历数组就可以.时间复杂度是 O(m * n),
     * 要找一个更高效的算法
     * */

    /**
     *
     * Runtime: 7 ms, faster than 57.78% of Java online submissions for
     *
     * Search a 2D Matrix II.
     *
     * 这个题目中的算法不算高明,只能说是减少了一些操作的时间.
     * 要从答案中学习一下,还有没有比较好的解法.
     *
     * */
    public boolean searchMatrixSlow(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = 0;
        while (i < m  || j < n){
            if (matrix[i][j] == target) {
                return true;
            }else if ( target < matrix[i][j]){
                // matrix[i-1][j-1] < target < matrix[i][j]
                return searchRowAndCol(matrix, target, i, j);
            }else {
                if (i == m - 1 && j== n-1) {
                    break;
                }
                if (i < m-1) {
                    i++;
                }
                if (j < n-1) {
                    j++;
                }
            }
        }
        return false;
    }

    private boolean searchRowAndCol(int[][] matrix, int target, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = row; i < m; i++) {
            for (int j = 0; j <= col; j++) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    break;
                }
            }
        }
        for (int i = col; i < n; i++) {
            for (int j = 0; j <= row; j++) {
                if (matrix[j][i] == target) {
                    return true;
                } else if (matrix[j][i] > target){
                    break;
                }
            }
        }
        return false;
    }
    /**
     * 只关注右边的结构,不能处理这个问题, 连题目中的例子都过不了,这个方法是失败的.只根据题目中的一句话的提示,没有做出来.
     * */
    public boolean searchMatrixFailed(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int col = n -1;
        while (i < m) {
            if (matrix[i][col] == target) {
                return true;
            } else if (matrix[i][col] < target) {
                i++;
            } else {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == target){
                        return true;
                    }else if(matrix[i][j] > target) {
                        return false;
                    }
                }
                return false;
            }
        }
        return false;
    }

    /**
     * Runtime: 5 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix II.
     *
     * 看答案之后,终于知道这个题目的做法,时间复杂度最小O(m + n)
     * 大体思路:
     *  1. 从 matrix 的右上角开始进行比较
     *  2. 如果 matrix 当前值 == target, 直接返回 true
     *  3. 如果 matrix 当前值 > target, 所以 matrix 大于当前这一行中的所有的值,所以行数+1,再进行下一轮比较.
     *  4. 如果 matrix 当前值 < target, 所以 matrix 小于当前这一行中的所有的值,所以行数+1,再进行下一轮比较.
     *  5. 如果最终还是没有找到,则返回 false.
     *
     *  总体来看,是一个从右上到左下的一个比较的过程
     *
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length -1;
        int m = matrix.length;
        while (row < m && col >= 0) {
            if (matrix[row][col] > target) {
                 col--;
            } else if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target){
                row++;
            }
        }
        return false;
    }

    public static void main(String[] arguments) {
//        int[][] matrix = new int[1][1];
//        int[] row = new int[]{-5};
//        matrix[0] = row;

//        int[][] matrix = new int[][] {
//                {1, 2,  3,  4,  5},
//                {6, 7,  8,  9,  10},
//                {11,12, 13, 14, 15},
//                {16,17, 18, 19, 20},
//                {21,22, 23, 24, 25}};
//        int target = 15;

        int[][] matrix = new int[][] {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        int target = 5;
        Solution solution = new Solution();
        System.out.printf("" + solution.searchMatrix(matrix, target));
    }
}
