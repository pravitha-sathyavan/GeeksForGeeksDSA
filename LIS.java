/*

Longest Increasing Subsequence
Given an array a[ ] of n integers, find the Length of the Longest Strictly Increasing Subsequence.

A sequence of numbers is called "strictly increasing" when each term in the sequence is smaller than the term that comes after it.
Example 1:

Input: n = 6, a[ ] = {5,8,3,7,9,1}
Output: 3
Explanation: There are more than one LIS in this array.  
One such Longest increasing subsequence is {5,7,9}.
Example 2:

Input: n = 16, a[ ] = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}
Output: 6
Explanation: There are more than one LIS in this array. 
One such Longest increasing subsequence is {0,2,6,9,13,15}.
Your Task:
You do not need to read input or print anything. Complete the function longestSubsequence() which takes the given array and its size as input parameters and returns the length of the longest increasing subsequence.

Expected Time Complexity : O( n*log(n) )
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 104
0 ≤ a[i] ≤ 106

*/

class Solution {
    
    static int dp[][];
    
    static int longestSubsequence(int n, int a[]) {
        dp = new int[a.length+1][a.length+1];
        for(int i=0;i<=a.length;i++)
            Arrays.fill(dp[i],-1);
        return fn(a, 0, -1);
    }
    
    static int fn(int a[], int index, int prev){
        if(index >= a.length)
            return 0;
         
        if(dp[index][prev+1] !=-1)
            return dp[index][prev+1];
         
        int take = 0;
        int notTake = fn(a, index+1, prev);
        
        
        if(prev==-1 || a[index]>a[prev]){
            take =  1+ fn(a, index+1, index);
        }
        
        return dp[index][prev+1] = Math.max(take, notTake);
    }
}

/*
Implementation

Declare an array tail of size n, it will act as an auxiliary array giving length of LIS.
tail[0] will be same as a[0] initially.
Initialize a variable lastIndex with 0, to keep track of last index till which tail array is filled.
Run a loop for i from 1 to n-1:
Find index of element in tail array, which is just greater than or equal to arr[i] using binary search.
If no such element exist, then index will be lastIndex+1. 
 tail[index] will be made equal to arr[i].
Update lastIndex as max of lastIndex and index.
Return (lastIndex+1) as answer because it will be the length of auxiliary array tail till which it is filled.
*/


class Solution {
    // binary search function finds the position of the first integer
    // in arr[] which is greater than or equal to 'value'.
    static int binarySearch(int arr[], int l, int h, int value) {
        // if new value is greater than all array values,
        // then it is placed at the end.
        if (value > arr[h]) return h + 1;

        // binary search algorithm.
        while (h > l) {
            int middle = (h + l) / 2;
            if (arr[middle] == value) return middle;

            if (arr[middle] > value)
                h = middle;

            else
                l = middle + 1;
        }

        return h;
    }

    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[]) {
        // tail[i] holds the last value in a subsequence of length i+1.
        int[] tail = new int[size];
        tail[0] = a[0];

        // the position of last filled index in tail[].
        int lastIndex = 0;

        for (int i = 1; i < size; i++) {
            // getting the furthest possible index for a[i].
            int index = binarySearch(tail, 0, lastIndex, a[i]);

            tail[index] = a[i];
            // updating lastIndex.
            lastIndex = Math.max(lastIndex, index);
        }
        // returning the result.
        return lastIndex + 1;
    }
}

