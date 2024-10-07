/*
Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:
Input: s = "cbbd"
Output: "bb"
 
Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.

*/

import java.util.*;
class Solution {

    static int[][] dp;
    public String longestPalindrome(String s) {
        dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        if(s.length()==1)
            return s;
        getPalindrome(s,0,s.length()-1);
        int n = s.length();

        int maxLength = -1;
        int start = 0;
        int end = 1;

        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                
                if(dp[i][j]==1){
                    if((Math.abs(j-i))>maxLength){
                        maxLength=Math.abs(j-i);
                        start = i;
                        end = j+1;
                    }
                }
            }
        }
        return s.substring(start,end);
    }

    public int getPalindrome(String s, int start, int end){
        if(start == end){
            dp[start][end]= 1;
            return 1;
        }
        if(end == start+1 && s.charAt(end)==s.charAt(start)){
            dp[start][end] = 1;
            return 1;
        }
        if(end == start+1 && s.charAt(end)!=s.charAt(start)){
            dp[start][end] = 0;
            return 0;
        }
        if(dp[start][end]!=-1)
            return dp[start][end];
        dp[start+1][end] = getPalindrome(s, start+1, end);
        dp[start][end-1] = getPalindrome(s, start, end-1);
        if(s.charAt(start)==s.charAt(end) && getPalindrome(s,start+1,end-1)==1)
            dp[start][end] = 1;
        else
            dp[start][end] = 0;  
        return dp[start][end];  
    }

}
