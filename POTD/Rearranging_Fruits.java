import java.util.*;
public class Rearranging_Fruits {
    
}
/*
 * 2561. Rearranging Fruits

avatar
Discuss Approach
arrow-up
Solved
Hard
Topics
premium lock icon
Companies
Hint
You have two fruit baskets containing n fruits each. You are given two 0-indexed integer arrays basket1 and basket2 representing the cost of fruit in each basket. You want to make both baskets equal. To do so, you can use the following operation as many times as you want:

Chose two indices i and j, and swap the ith fruit of basket1 with the jth fruit of basket2.
The cost of the swap is min(basket1[i],basket2[j]).
Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.

Return the minimum cost to make both the baskets equal or -1 if impossible.

 

Example 1:

Input: basket1 = [4,2,2,2], basket2 = [1,4,1,2]
Output: 1
Explanation: Swap index 1 of basket1 with index 0 of basket2, which has cost 1. Now basket1 = [4,1,2,2] and basket2 = [2,4,1,2]. Rearranging both the arrays makes them equal.
Example 2:

Input: basket1 = [2,3,4,1], basket2 = [3,2,5,1]
Output: -1
Explanation: It can be shown that it is impossible to make both the baskets equal.
 

Constraints:

basket1.length == basket2.length
1 <= basket1.length <= 105
1 <= basket1[i],basket2[i] <= 109
 */
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<basket1.length; i++){
            map.put(basket1[i],map.getOrDefault(basket1[i],0)+1);
            min = Math.min(min,basket1[i]);
        }

        for(int j=0; j<basket2.length; j++){
            map.put(basket2[j],map.getOrDefault(basket2[j],0)-1);
            min = Math.min(min,basket2[j]);
        }

        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            int count = map.get(key);
            if(count%2!=0) return -1;
            for(int i=0; i<Math.abs(count/2); i++){
                list.add(key);
            }
        }
        Collections.sort(list);
        long res = 0;
        for(int i=0; i<list.size()/2; i++){
            res+= Math.min(2*min , list.get(i));
        }
        return res;
    }
}

// 2 3 4 1
// 3 2 5 1

// 4 2 2 2
// 1 4 1 2

// 1 100 100
// 1 200 200

// 2 3 300 300
// 100 100 3 2

// 





