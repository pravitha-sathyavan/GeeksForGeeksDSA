/*
Maximize The Cut Segments
Given an integer n denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
After performing all the cut operations, your total number of cut segments must be maximum. Return the maximum number of cut segments possible.

Note: if no segment can be cut then return 0.

Examples:

Input: n = 4, x = 2, y = 1, z = 1
Output: 4
Explanation: Total length is 4, and the cut
lengths are 2, 1 and 1.  We can make
maximum 4 segments each of length 1.
Input: n = 5, x = 5, y = 3, z = 2
Output: 2
Explanation: Here total length is 5, and
the cut lengths are 5, 3 and 2. We can
make two segments of lengths 3 and 2.
Expected Time Complexity : O(n)
Expected Auxiliary Space: O(n)

Constraints
1 <= n, x, y, z <= 104
*/


class Solution
{
    static int[] dp;
    public int maximizeCuts(int n, int x, int y, int z)
    {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = fn(n,x,y,z);
        if(ans>=0)
            return ans;
        return 0;
    }
     
    static int fn(int n,int x,int y,int z){
        if(n==0)
            return 0;
        int cx = Integer.MIN_VALUE;
        int cy = Integer.MIN_VALUE;
        int cz = Integer.MIN_VALUE;
        if(dp[n]!=-1)
            return dp[n];
        if(n>=x)
            cx = fn(n-x,x,y,z)+1;
        if(n>=y)
            cy = fn(n-y,x,y,z)+1;
        if(n>=z)
            cz = fn(n-z,x,y,z)+1;
        dp[n] = Math.max(Math.max(cx,cy),cz);
        return dp[n]; 
    }
    
}
