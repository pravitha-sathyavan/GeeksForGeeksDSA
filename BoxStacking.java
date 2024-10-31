/*

Box Stacking
You are given a set of N types of rectangular 3-D boxes, where the ith box has height h, width w and length l.
Your task is to create a stack of boxes which is as tall as possible, 
but you can only stack a box on top of another box if the dimensions of the 2-D base of the lower box are each strictly larger than those of the 2-D base of the higher box. Of course, you can rotate a box so that any side functions as its base.It is also allowable to use multiple instances of the same type of box. Your task is to complete the function maxHeight which returns the height of the highest possible stack so formed.
 
Note: 
Base of the lower box should be strictly larger than that of the new box we're going to place. This is in terms of both length and width, not just in terms of area. So, two boxes with same base cannot be placed one over the other.

 

Example 1:

Input:
n = 4
height[] = {4,1,4,10}
width[] = {6,2,5,12}
length[] = {7,3,6,32}
Output: 60
Explanation: One way of placing the boxes is
as follows in the bottom to top manner:
(Denoting the boxes in (l, w, h) manner)
(12, 32, 10) (10, 12, 32) (6, 7, 4) 
(5, 6, 4) (4, 5, 6) (2, 3, 1) (1, 2, 3)
Hence, the total height of this stack is
10 + 32 + 4 + 4 + 6 + 1 + 3 = 60.
No other combination of boxes produces a
height greater than this.
Example 2:

Input:
n = 3
height[] = {1,4,3}
width[] = {2,5,4}
length[] = {3,6,1}
Output: 15
Explanation: One way of placing the boxes is
as follows in the bottom to top manner:
(Denoting the boxes in (l, w, h) manner)
(5, 6, 4) (4, 5, 6) (3, 4, 1), (2, 3, 1) 
(1, 2, 3).
Hence, the total height of this stack is
4 + 6 + 1 + 1 + 3 = 15
No other combination of boxes produces a
height greater than this.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxHeight() which takes three arrays height[], width[], length[], and N as a number of boxes and returns the highest possible stack height which could be formed.


Expected Time Complexity : O(N*N)
Expected Auxiliary Space: O(N)


Constraints:
1<= N <=100
1<= l,w,h <=100

*/


class Solution
{
    
    static class Box{
        int length;
        int height;
        int width;
        
        Box(int length, int width, int height){
            this.length = length;
            this.height = height;
            this.width = width;
        }
    }
    
    static class BoxSort implements Comparator<Box>{
        public int compare(Box b1, Box b2){
            if(b1.length==b2.length){
                return b2.width-b1.width;
            } else{
                return b2.length - b1.length;
            }
        }
    }
    
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        Box[] boxList = new Box[6*height.length];
        int j=0;
        for(int i=0;i<height.length;i++){
            boxList[j]=new Box(height[i],width[i],length[i]);
            j++;
            boxList[j]=new Box(width[i],height[i],length[i]);
            j++;
            boxList[j]=new Box(length[i],width[i],height[i]);
            j++;
            boxList[j]=new Box(height[i],length[i],width[i]);
            j++;
            boxList[j]=new Box(length[i],height[i],width[i]);
            j++;
            boxList[j]=new Box(width[i],length[i],height[i]);
            j++;
            //Arrays.sort(boxList, new BoxSort());
        }
        Arrays.sort(boxList, new BoxSort());
        return getHeight(boxList);
    }
    
    static int getHeight(Box[] boxList){
        int n = boxList.length;
        int[] dp = new int[n];

        // Initialize dp array with each box's own height as the starting point
        for (int i = 0; i < n; i++) {
            dp[i] = boxList[i].height;
        }

        int maxHeight = 0;

        // Compute maximum stackable height for each box
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if box j can be placed below box i
                if (boxList[i].width < boxList[j].width && boxList[i].length < boxList[j].length) {
                    dp[i] = Math.max(dp[i], dp[j] + boxList[i].height);
                }
            }
            // Track the maximum height achievable
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;
    }
    
}
