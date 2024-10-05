/*
Longest Common Subsequence
Given two strings str1 & str 2 of length n & m respectively, return the length of their longest common subsequence. If there is no common subsequence then, return 0. 

A subsequence is a sequence that can be derived from the given string by deleting some or no elements without changing the order of the remaining elements. For example, "abe" is a subsequence of "abcde".
Example 1:

Input: n = 6, str1 = ABCDGH and m = 6, str2 = AEDFHR
Output: 3
Explanation: LCS for input strings “ABCDGH” and “AEDFHR” is “ADH” of length 3.
Example 2:

Input: n = 3, str1 = ABC and m = 2, str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is "AC" of length 2.
Example 3:

Input: n = 4, str1 = XYZW and m = 4, str2 = XYWZ
Output: 3
Explanation: There are two common subsequences of length 3 “XYZ”, and”XYW”, and no common subsequence. of length more than 3.
Your Task:
You do not need to read input or print anything. Complete the function lcs() which takes the two strings and their lengths as input parameters and returns the length of the Longest Common Subsequence. 

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1<= n, m <=103
str1 and str2 are in uppercase alphabet
*/

class Solution {
    static int dp[][];
    static int lcs(int n, int m, String str1, String str2) {
        dp = new int[n+1][m+1];
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i],-1);
        }
        return fn(0,0,str1,str2);
    }
    
    static int fn(int i1, int i2, String s1, String s2){
        if(i1==s1.length() || i2==s2.length())
            return 0;
        if(dp[i1][i2]!=-1){
            return dp[i1][i2];
        }
        if(s1.charAt(i1)==s2.charAt(i2)){
            dp[i1][i2] = 1+fn(i1+1,i2+1,s1,s2);
            return (dp[i1][i2]);
        }
        else{
            dp[i1+1][i2] = fn(i1+1,i2,s1,s2);
            dp[i1][i2+1] = fn(i1,i2+1,s1,s2);
            return Math.max(dp[i1+1][i2],dp[i1][i2+1]);
        }
    }
}
