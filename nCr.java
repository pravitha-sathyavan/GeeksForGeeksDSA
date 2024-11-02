/*

Find nCr for given n and r.

Example 1:
Input:
n = 3, r = 2
Output: 3
Example 2:

Input:
n = 4, r = 2
Output: 6
Your Task:
Complete the function nCrModp() which takes two integers n and r as input parameters and returns the nCr mod 109+7.
Note: nCr does not exist when r > n. Hence, return 0 in that case.

Expected Time Complexity : O(N*R)
Expected Auxiliary Space: O(N)

Constraints:
1<= n <= 103
1<= r <= 103
*/

class Solution
{
    
    static int p = 1000000007;
    
    public static int min(int a, int b) 
    { 
        return (a<b)? a: b;  
    }
    
    //Function to return nCr mod 10^9+7 for given n and r.
    public static int nCrModp(int n, int r)
    {
        //array C[] is going to store last row of pascal triangle at the end.
        //last entry of last row is nCr. 
        int C[] = new int[r+1];
        Arrays.fill(C, 0);
    
        //top row of Pascal Triangle 
        C[0] = 1; 
    
        //one by one constructing remaining rows of Pascal 
        //triangle from top to bottom.    
        for (int i = 1; i <= n; i++) 
        { 
          //filling entries of current row using previous row values. 
          for (int j = min(i, r); j > 0; j--) 
            // nCj = (n-1)Cj + (n-1)C(j-1); 
            C[j] = (C[j]%p + C[j-1]%p)%p; 
        } 
        
        //returning the result.
        return C[r];
    }
}


class Solution
{
    static int x = 1000000007;
    public static int nCrModp(int n, int r)
    {
       if(r>n)
            return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1]*i)%x;
        }
        int r1 = (dp[r]*dp[n-r]) % x;
        return dp[n]/r1;
    }
}

/*
The code still contains issues with modular arithmetic, 
particularly with division, as it does not correctly handle division under a modulus. Here’s a breakdown of the issues and how to correct them:

Incorrect Handling of Division in Modular Arithmetic:
The line dp[n]/r1 is problematic. Division in modular arithmetic requires the use of the modular inverse, not straightforward division.
*/





