/*
Word Break
Given a string s and a dictionary of n words dictionary, find out if "s" can be segmented into a space-separated sequence of dictionary words.
Return 1 if it is possible to break the s into a sequence of dictionary words, else return 0. 

Note: From the dictionary dictionary each word can be taken any number of times and in any order.

Examples :

Input: n = 6, s = "ilike", dictionary = { "i", "like", "sam", "sung", "samsung", "mobile"}
Output: 1
Explanation: The string can be segmented as "i like".
Input: n = 6, s = "ilikesamsung", dictionary = { "i", "like", "sam", "sung", "samsung", "mobile"}
Output: 1
Explanation: The string can be segmented as "i like samsung" or "i like sam sung".
Expected Time Complexity: O(len(s)2)
Expected Space Complexity: O(len(s))

Constraints:
1 ≤ n ≤ 12
1 ≤ len(s) ≤ 1100
*/

class Solution
{
    static int dp[];
    public static int wordBreak(int n, String s, ArrayList<String> dictionary )
    {
        dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        if(check(s,dictionary,0))
            return 1;
        return 0;
    }
    
    static boolean check(String s,  ArrayList<String> dictionary, int start){
        if(start==s.length())
            return true;
        if(dp[start]!=-1){
            if(dp[start]==1)
                return true;
            else
                return false;
        }
        for(int j = start+1;j<=s.length();j++){
            if(dictionary.contains(s.substring(start,j)) && check(s,dictionary,j)){
                dp[start] = 1;
                return true;
            }
        }
        dp[start] = 0;
        return false;
    }
}
