/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 *
 * calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 *
 * But can you do it in linear time O(n) /possibly in a single pass?
 *
 * Space complexity should be O(n).
 *
 * Can you do it like a boss? Do it without using any builtin function like
 *
 * __builtin_popcount in c++ or in any other language.
 *
 * */
package dynamic_programming.counte_bites_338;

public class Solution {
    /**
     * 这个关系是不好找的, 但是一旦找到这个规律之后,就很好弄了.
     * dp[i] = dp[i/2] + i%2;
     *
     * Runtime: 1 ms, faster than 99.87% of Java online submissions for Counting Bits.
     *
     * */
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int[] dp = new int[num+1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i/2] + i%2;
        }
        return dp;
    }

    public static void main(String[] arguments) {
        int num = 5;
        Solution solution = new Solution();
        int[] res = solution.countBits(num);
        for (Integer item : res) {
            System.out.println(item);
        }
    }
}
