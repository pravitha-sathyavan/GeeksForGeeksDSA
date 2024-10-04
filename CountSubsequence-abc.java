/*
Count subsequences of type a^i, b^j, c^k
Given a string S, the task is to count number of subsequences of the form aibjck, where i >= 1, j >=1 and k >= 1.

Note: 
1. Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.
2.  For large test cases, the output value will be too large, return the answer MODULO 10^9+7

 

Example 1:

Input:
S = "abbc"
Output: 3
Explanation: Subsequences are abc, abc and abbc.

Example 2:

Input:
S = "abcabc"
Output: 7
Explanation: Subsequences are abc, abc,
abbc, aabc abcc, abc and abc.

Your Task:
You don't need to read input or print anything. Your task is to complete the function fun() which takes the string S as input parameter and returns the number of subsequences which follows given condition.


Expected Time Complexity: O(Length of String).
Expected Auxiliary Space: O(1) .


Constraints:
1 <= |S| <= 105
*/

class Solution
{
    public int fun(String s)
    {
        // Initialize counts of different subsequences
        // caused by different combination of 'a'
        long aCount = 0;
 
        // Initialize counts of different subsequences
        // caused by different combination of 'a' and
        // different combination of 'b'
        long bCount = 0;
 
        // Initialize counts of different subsequences
        // caused by different combination of 'a', 'b'
        // and 'c'.
        long cCount = 0;
        long x = 1000000007;
        // Traverse all characters of given string
        for (int i = 0; i < s.length(); i++) {
            /* If current character is 'a', then
               there are following possibilities :
                 a) Current character begins a new
                    subsequence.
                 b) Current character is part of aCount
                    subsequences.
                 c) Current character is not part of
                    aCount subsequences. */
            if (s.charAt(i) == 'a')
                aCount = (1 + 2 * aCount) % x;
 
            /* If current character is 'b', then
               there are following possibilities :
                 a) Current character begins a new
                    subsequence of b's with aCount
                    subsequences.
                 b) Current character is part of bCount
                    subsequences.
                 c) Current character is not part of
                    bCount subsequences. */
            else if (s.charAt(i) == 'b')
                bCount = (aCount + 2 * bCount) % x ;
 
            /* If current character is 'c', then
               there are following possibilities :
                 a) Current character begins a new
                    subsequence of c's with bCount
                    subsequences.
                 b) Current character is part of cCount
                    subsequences.
                 c) Current character is not part of
                    cCount subsequences. */
            else if (s.charAt(i) == 'c')
                cCount = (bCount + 2 * cCount) % x ;
        }
        return (int) (cCount % x);
    }
}
