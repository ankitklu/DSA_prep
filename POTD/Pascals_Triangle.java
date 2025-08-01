/*
 * 118. Pascal's Triangle
Solved

avatar
Discuss Approach
arrow-up
Easy
Topics
premium lock icon
Companies
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        int res[][]=new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(i==j || j==0){
                    res[i][j]=1;
                    list.add(res[i][j]);
                }
                else{
                    res[i][j]=res[i-1][j-1]+res[i-1][j];
                    list.add(res[i][j]);
                }
            }
            result.add(list);
        }
        return result;
    }
}