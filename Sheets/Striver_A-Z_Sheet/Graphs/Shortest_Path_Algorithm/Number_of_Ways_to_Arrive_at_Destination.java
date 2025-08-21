import java.util.*;
/*
 * 1976. Number of Ways to Arrive at Destination
Solved

avatar
Discuss Approach
arrow-up
Medium
Topics
premium lock icon
Companies
Hint
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

 

Example 1:


Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
Example 2:

Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 

Constraints:

1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection.
 */

class Solution {
    static class Pair{
        int node;
        int time;
        public Pair(int node , int time){
            this.node= node;
            this.time = time;
        }
    }
    static int mod = 1000000007;
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int road[]: roads){
            int src = road[0];
            int dest = road[1];
            int time = road[2];
            graph.get(src).add(new Pair(dest, time));
            graph.get(dest).add(new Pair(src, time));
        }

        long dist[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0]=0;

        long ways[] = new long[n];
        ways[0] = 1;


        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.time - b.time);
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            long node = top.node;
            long d = top.time;
            for(Pair neigh: graph.get((int)node)){
                long curr = neigh.node;
                long wt = neigh.time;
                if(dist[(int)curr] > d+wt){
                    dist[(int)curr] = d+wt;
                    pq.add(new Pair((int)curr,(int)(d+wt)));
                    ways[(int)curr] = ways[(int)node];

                }
                else if(d+wt == dist[(int)curr]){
                    ways[(int)curr] = (ways[(int)curr] + ways[(int)node])%mod;
                }

            }
        }
        return (int)ways[n-1]%mod;

    }
}