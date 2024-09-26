/*
Coin Change - Minimum number of coins
You are given an amount denoted by value. You are also given an array of coins. The array contains the denominations of the given coins. You need to find the minimum number of coins to make the change for value using the coins of given denominations. Also, keep in mind that you have infinite supply of the coins.

Example 1:

Input:
value = 5
numberOfCoins = 3
coins[] = {3,6,3}
Output: Not Possible
Explanation:We need to make the change for
value = 5 The denominations are {3,6,3}
It is certain that we cannot make 5 using
any of these coins.
Example 2:

Input:
value = 10
numberOfCoins = 4
coins[] = {2 5 3 6}
Output: 2
Explanation:We need to make the change for
value = 10 The denominations are {2,5,3,6}
We can use two 5 coins to make 10. So
minimum coins are 2.
Your Task:
You only need to complete the function minimumNumberOfCoins() that take array of coins, size of array, and value as parameters. You need to return the minimum number of coins required. If it is not possible to make the exact value out of the given coin denominations, return -1 ("Not Possible" will be printed by the driver's code in this case).

Expected Time Complexity: O(number of coins * value).
Expected Auxiliary Space: O(value)

Constraints:
1 <= value <= 103
1 <= numberOfCoins <= 103
1 <= coinsi <= 1000
*/


class Solution
{
    //Function to find the minimum number of coins to make the change 
    //for value using the coins of given denominations.
    static long dp[][];
    public long minimumNumberOfCoins(int coins[],int numberOfCoins,int value)
    {
        dp = new long[numberOfCoins][value+1];
        for(long[] i:dp)
            Arrays.fill(i,-1L);
        long ans = getCount(coins,0,value,numberOfCoins);
        if(ans == Integer.MAX_VALUE)
          return -1;
        return ans;
    }
    
     public long getCount(int coins[],int index,int value, int numberOfCoins)
     {
        if(value == 0)
            return 0;
        if(index == numberOfCoins) 
            return Integer.MAX_VALUE;
        
        if(dp[index][value]!=-1)
            return dp[index][value];
        long take = Integer.MAX_VALUE;
        long notTake;
        
        if(value>=coins[index])
            take = 1 + getCount(coins,index,value-coins[index], numberOfCoins);
        notTake =  getCount(coins,index+1,value, numberOfCoins);
        
        long count = Math.min(take,notTake);
        dp[index][value] = count;
        return count;
     }
    
}
