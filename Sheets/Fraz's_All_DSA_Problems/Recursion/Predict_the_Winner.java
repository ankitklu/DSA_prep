public class Predict_the_Winner {
    
}
/*
 * 486. Predict the Winner

avatar
Discuss Approach
arrow-up
Solved
Medium
Topics
premium lock icon
Companies
You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.

Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0. At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen number to their score. The game ends when there are no more elements in the array.

Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return true. You may assume that both players are playing optimally.

 

Example 1:

Input: nums = [1,5,2]
Output: false
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return false.
Example 2:

Input: nums = [1,5,233,7]
Output: true
Explanation: Player 1 first chooses 1. Then player 2 has to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
 

Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 107
 */

class Solution {
    public boolean predictTheWinner(int[] nums) {
        return helper(nums, 0,nums.length-1, 0,true)>=0;
    }
    public int helper(int nums[], int start, int end, int score, boolean p1_turn){
        if(start>end){
            return score;
        }

        if(p1_turn){
            int first= helper(nums, start+1, end, score+nums[start], false);
            int last= helper(nums, start, end-1, score+ nums[end], false);
            return Math.max(first , last);
        }
        else{
            int first = helper(nums, start+1, end, score-nums[start], true);
            int last= helper(nums, start, end-1, score-nums[end], true);
            return Math.min(first, last);
        }
    }
}