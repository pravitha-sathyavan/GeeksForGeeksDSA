/*

Count number of hops
A frog jumps either 1, 2, or 3 steps to go to the top. In how many ways can it reach the top of Nth step. As the answer will be large find the answer modulo 1000000007.

Example 1:

Input:
N = 1
Output: 1
Example 2:

Input:
N = 4
Output: 7
Explanation:Below are the 7 ways to reach
4
1 step + 1 step + 1 step + 1 step
1 step + 2 step + 1 step
2 step + 1 step + 1 step
1 step + 1 step + 2 step
2 step + 2 step
3 step + 1 step
1 step + 3 step
Your Task:
Your task is to complete the function countWays() which takes 1 argument(N) and returns the answer%(10^9 + 7).

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 105

*/


class Solution {
    static long[] dp;
    static long countWays(int n) {
        dp = new long[n+1];
        Arrays.fill(dp,-1);
        return countSteps(n);
    }
    
    static long countSteps(int n){
        long x = 1000000007;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;
        if(dp[n]!=-1)
            return dp[n];
        dp[n] = countSteps(n-1)%x + countSteps(n-2)%x + countSteps(n-3)%x;
        return dp[n]%x;
    }
}
