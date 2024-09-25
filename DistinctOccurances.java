/*
Distinct occurrences
Given two strings s and t of length n and m respectively. Find the count of distinct occurrences of t in s as a sub-sequence modulo 109 + 7.

Example 1:

Input:
s = "banana" , t = "ban"
Output: 
3
Explanation: 
There are 3 sub-sequences:[ban], [ba n], [b an].
Example 2:

Input:
s = "geeksforgeeks" , t = "ge"
Output: 
6
Explanation: 
There are 6 sub-sequences:[ge], [ge], [g e], [g e] [g e] and [g e].
Your Task:
You don't need to read input or print anything. Your task is to complete the function subsequenceCount() which takes two strings as argument s and t and returns the count of the sub-sequences modulo 109 + 7.

Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).

Constraints:
1 ≤ n,m ≤ 1000
*/


class Solution {
    
    static int[][] dp;
    static int solve(int i, int j, String s, String t)
    {
        // base case
        // if second string completed then we found the
        // matching pattern
        if (j == t.length()) {
            return 1;
        }
        // if first string is completed we can not find any
        // matching pattern.
        if (i == s.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int count = 0;
        // if character at i'th place is equal to character
        // at j'th place then
        // we can either take it or not take it.
        if (s.charAt(i) == t.charAt(j)) {
            count += solve(i + 1, j + 1, s, t) % 1000000007;
        }
        // if characters are not equal then we will increase
        // only first string
        count += solve(i + 1, j, s, t) % 1000000007;
        dp[i][j] = count;
        return count;
    }

    int subsequenceCount(String S, String T)
    {
        dp = new int[S.length()+1][T.length()+1];
        for (int i = 0; i < S.length() + 1; i++)
            Arrays.fill(dp[i], -1);
        return solve(0, 0, S, T) % 1000000007;
    }
}

/*
Complexity:

Time Complexity: O(N*M), As we have N*M different states in the recursive function using memoization.
Space Complexity: O(N*M), As we have made a dp matrix of size N*M.
*/
