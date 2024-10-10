/*

0 - 1 Knapsack Problem
You are given weights and values of items, and put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val and wt which represent values and weights associated with items respectively. Also given an integer W which represents knapsack capacity, find out the maximum sum values subset of val[] such that the sum of the weights of the corresponding subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don't pick it (0-1 property).

Examples :

Input: W = 4, val[] = {1,2,3}, wt[] = {4,5,1}
Output: 3
Explanation: Choose the last item that weighs 1 unit and holds a value of 3. 
Input: W = 3, val[] = {1,2,3}, wt[] = {4,5,6}
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)

Constraints:
2 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ val[i] ≤ 1000

*/

class Solution {
    
    static int[][] dp;
    static int knapSack(int W, int wt[], int val[]) {
        dp = new int[W+1][wt.length];
        for(int i=0;i<=W;i++){
            Arrays.fill(dp[i],-1);
        }
        return fn(W, wt, val, 0);
    }
    
    static int fn(int W, int wt[], int val[], int index){
        if(index==wt.length){
            return 0;
        }
        if(W==0){
            return 0;
        }
        if(dp[W][index]!=-1)
            return dp[W][index];
            
        int take = 0, notTake = 0;
        if(W>=wt[index]){
            take = val[index]+fn(W-wt[index],wt,val,index+1);
        }
        notTake = fn(W, wt, val,index+1);
        dp[W][index] = Math.max(take, notTake);
        return dp[W][index];
    }
}
