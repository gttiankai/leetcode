/**
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 *
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 *
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 *
 *
 * Follow up:
 *
 * If this function is called many times, how would you optimize it?
 *
 * */

package bit_manipulation.number_of_1_bits_191;

public class Solution {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of 1 Bits.
     * Memory Usage: 33.3 MB, less than 15.60% of Java online submissions for Number of 1 Bits.
     * */
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if( (n & 0x1) == 0x1) {
                ans++;
            }
            n = n >>1;
        }
        return ans;
    }
}
