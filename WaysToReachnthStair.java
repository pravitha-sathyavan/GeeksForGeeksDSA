/*
Ways to Reach the n'th Stair
There are n stairs, a person standing at the bottom wants to reach the top. 
The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does matter).

Examples:

Input: n = 4
Output: 5
Explanation: You can reach 4th stair in 5 ways. 
Way 1: Climb 2 stairs at a time. 
Way 2: Climb 1 stair at a time.
Way 3: Climb 2 stairs, then 1 stair and then 1 stair.
Way 4: Climb 1 stair, then 2 stairs then 1 stair.
Way 5: Climb 1 stair, then 1 stair and then 2 stairs.
Input: n = 10
Output: 89 
Explanation: There are 89 ways to reach the 10th stair.
Constraints:
1 ≤ n ≤ 32

*/

class Solution {
    
    static int[] dp;
    int countWays(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return countNoOfWays(n);
    }
    
    int countNoOfWays(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(dp[n]!=-1)
            return dp[n];
        dp[n] = countNoOfWays(n-1)+countNoOfWays(n-2);
        return dp[n];
    }
}
