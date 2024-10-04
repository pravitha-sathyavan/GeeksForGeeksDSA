/*
Given a set of numbers, check whether it can be partitioned into two subsets such that the sum of elements in both subsets is same or not.
Example 1:

Input:
N = 4
arr[] = {1,5,11,5}
Output: YES
Explanation: There exists two subsets
such that {1, 5, 5} and {11}.
Example 2:

Input:
N = 3
arr[] = {1,3,5}
Output: NO
Your Task:
Your task is to complete the findPartition() function which takes an array a[] and N as input parameter and return true if the given set can be partitioned into two subsets such that the sum of elements in both subsets is equal, else return false.
Note: The output will be YES or NO depending upon the value returned by your code. The printing is done by the driver's code.

Expected Time Complexity: O(N*S).
Expected Auxiliary Space: O(S) where S is the sum of the given Array.

Constraints:
1 <= N <= 100
0 <= arr[i] <= 1000
*/


class Solution 
{
    static int dp[][];
    public boolean findPartition(int[] a, int n)
    {
        
        int sum = 0;
        for(int i=0;i<a.length;i++){
           sum += a[i]; 
        }
        if(sum % 2!=0)
            return false;
        dp = new int[a.length+1][sum/2+1];
        for(int i=0;i<a.length+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return checkSum(a,sum/2,0);
    }
    
    public static boolean checkSum(int[] a,int sum,int i){
        if(sum<0)
            return false;
        if(i==a.length && sum >0){
            return false;
        }
        if(sum == 0){
            return true;
        }
        if(dp[i][sum]!=-1)
            return dp[i][sum] == 0?true:false;
            
        boolean b1;
        boolean b2 = false;
        if(sum-a[i]<0)
            b1 = false;
        else{
            b1 = checkSum(a, sum - a[i], i+1);
            dp[i+1][sum-a[i]] = b2? 0: 1;
        }
        
        b2 = checkSum(a, sum, i+1);
        dp[i+1][sum] = b2 ? 0: 1;
        dp[i][sum] = b1||b2 ? 0: 1;
        return b1||b2;
    }
}
