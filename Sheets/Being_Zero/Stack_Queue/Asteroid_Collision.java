package Sheets.Being_Zero.Stack_Queue;
import java.util.*;

public class Asteroid_Collision {
    
}
/*
 * 735. Asteroid Collision
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Hint
We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int curr: asteroids){
            boolean destroy= false;
            while(!stack.isEmpty() && curr<0 && stack.peek()>0){
                if(stack.peek()==Math.abs(curr)){
                    stack.pop();
                    destroy = true;
                    break;
                }
                else if(stack.peek()<Math.abs(curr)){
                    stack.pop();
                }
                else{
                    destroy= true;
                    break;
                }

            }
            if(!destroy){
                stack.push(curr);
            }
        }
        List<Integer> l = new ArrayList<>();
        while(!stack.isEmpty()){
            l.add(0,stack.pop());
        }
        int index=0;
        int ans[]= new int[l.size()];

        for(Integer i : l){
            ans[index++]=i;
        }
        return ans;

    }
}
