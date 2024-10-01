/*
Maximum Subarray Sum
Given a list of N integers. Find the contiguous sub-array with maximum sum.
 
Example 1:
Input:
N = 5
array = {1,2,3,-2,5}
Output: 9
Explanation:Max subarray sum is 9 of elements
(1, 2, 3, -2, 5) which is a contiguous subarray.

Example 2:
Input:
N = 4
array = {-1 , -2 , -3 , -4}
Output: -1
Explanation: Max subarray sum is -1 of elements
(-1) which is a contiguous subarray.
 
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxSubArray() which takes a list of numbers as a parameter and returns an integer with a maximum subarray sum.
 
Expected Time Complexity : O(N)
Expected Auxiliary Space: O(1)
 
Constraints:
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107
Sum of N over all testcases doesn't exceed 107
*/



class Sol
{
    static int[] dp;
    public static int maxSubArray(ArrayList<Integer> array)
    {
        int n = array.size();
	    int max_sum = array.get(0);
	    int curr_sum = array.get(0);
	
	    for(int i=1;i<n;i++)
	        {
	            if(curr_sum < 0)
			        curr_sum = 0;
		        curr_sum += array.get(i);
		        max_sum = Math.max(max_sum, curr_sum);
	        }
	
	    return max_sum;
    }
    
}
