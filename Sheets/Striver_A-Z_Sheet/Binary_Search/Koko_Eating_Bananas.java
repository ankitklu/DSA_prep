import java.util.*;
public class Koko_Eating_Bananas {
    
}
/*
 * 875. Koko Eating Bananas
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low= 1 ;
        int high = Integer.MIN_VALUE;
        for(int ele : piles){
            high = Math.max(ele, high);
        }
        int min=high;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(isPossible(piles, mid, h)){
                min = Math.min(min, mid);
                high= mid-1;
            }
            else{
                low= mid+1;
            } 
        }
        return min;

    }
    public boolean isPossible(int[] arr, int speed, int h) {
        int totalHours = 0;
        for (int i = 0; i < arr.length; i++) {
            totalHours += (arr[i] + speed - 1) / speed;  
            if (totalHours > h) {
                return false;  
            }
        }
        return totalHours <= h;
    }
}

// 1 2 3 4 5 6 7 8 9 10 11
// L         M          H
