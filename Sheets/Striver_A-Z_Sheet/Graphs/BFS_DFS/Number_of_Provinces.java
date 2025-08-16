import java.util.*;
/*
 * 547. Number of Provinces
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 */

public class Number_of_Provinces {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = isConnected[0].length;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    graph.get(i).add(j);
                }
            }
        }
        System.out.println(graph);

        boolean vis[] = new boolean[n];
        int c=0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                c++;
                dfs(graph, isConnected, vis, i);
            }
        }
        return c;
    }
    public void dfs(List<List<Integer>> graph, int isConnected[][], boolean vis[], int src){
        vis[src] = true;
        // for(List<Integer> neigh: graph.get(src)){
            for(Integer node: graph.get(src)){
                if(!vis[node]){
                    dfs(graph, isConnected, vis, node);
                }
            }
        // }
    }
}
