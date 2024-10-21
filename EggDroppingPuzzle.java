/*

Egg Dropping Puzzle
You are given N identical eggs and you have access to a K-floored building from 1 to K.

There exists a floor f where 0 <= f <= K such that any egg dropped from a floor higher than f will break, and any egg dropped from or below floor f will not break.
There are few rules given below. 

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
Return the minimum number of moves that you need to determine with certainty what the value of f is.

For more description on this problem see wiki page

Example 1:

Input:
N = 1, K = 2
Output: 2
Explanation: 
1. Drop the egg from floor 1. If it 
   breaks, we know that f = 0.
2. Otherwise, drop the egg from floor 2.
   If it breaks, we know that f = 1.
3. If it does not break, then we know f = 2.
4. Hence, we need at minimum 2 moves to
   determine with certainty what the value of f is.
Example 2:

Input:
N = 2, K = 10
Output: 4
Your Task:
Complete the function eggDrop() which takes two positive integer N and K as input parameters and returns the minimum number of attempts you need in order to find the critical floor.

Expected Time Complexity : O(N*(K^2))
Expected Auxiliary Space: O(N*K)

Constraints:
1<=N<=200
1<=K<=200

*/



class Solution 
{
    static int dp[][];
    static int eggDrop(int n, int k) 
	{
	    dp = new int[n+2][k+2];
	    for(int i=0;i<n+2;i++)
	        Arrays.fill(dp[i],-1);
	    return countMoves(k,n);
	}
	
	static int countMoves(int floors, int eggs){
	    
	    if(eggs==1)
	       return floors;
	    if(floors <= 1)
	        return floors;
	   if(dp[eggs][floors]!=-1)
	        return dp[eggs][floors];
	   int moves = Integer.MAX_VALUE;
	       
	    for(int i=1;i<=floors;i++){
	        int countBreak = countMoves(i-1,eggs-1);
	        int countNotBreak = countMoves(floors-i, eggs);
	        int currentMoveCount = Math.max(countBreak, countNotBreak)+1;
	        moves = Math.min(currentMoveCount, moves);
	    }
	    dp[eggs][floors] = moves;
	    return moves;
	}
}




/* Below code is not correct bc it uses binary search.
This strategy is appropriate when the search space can be divided evenly and both parts of the search space can be solved independently, such as in a classic binary search on a sorted array.

However, the egg drop problem doesn't work this way because:

The result of a drop either causes the egg to break or not break, which means the problem branches into two different subproblems:
If the egg breaks, you are only concerned with the floors below the current floor (but with one fewer egg).
If the egg does not break, you are concerned with the floors above the current floor (but with the same number of eggs).
The code assumes that we can evenly split the floors, but in reality, when the egg breaks, the number of floors reduces non-linearly depending on where the egg is dropped.


class Solution 
{
    static int eggDrop(int n, int k) 
	{
	    return countBinary(1, k, n);
	}
	
	static int countBinary(int start, int end, int n){
	    if(start == end)
	        return 1;
	    if(n==1)
	        return end-1;
	    int mid = start + (end-start)/2;
	    int firstHalf = countBinary(start, mid, n-1);
	    int secondHalf = countBinary(mid +1,end,n);
	    return Math.max(firstHalf, secondHalf) +1;
	}
}

*/
