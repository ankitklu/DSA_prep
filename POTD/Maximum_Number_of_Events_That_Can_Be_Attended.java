import java.util.*;
public class Maximum_Number_of_Events_That_Can_Be_Attended {
    
}
// 1353. Maximum Number of Events That Can Be Attended
// Solved

// avatar
// Discuss Approach
// arrow-up
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

// You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

// Return the maximum number of events you can attend.

 

// Example 1:


// Input: events = [[1,2],[2,3],[3,4]]
// Output: 3
// Explanation: You can attend all the three events.
// One way to attend them all is as shown.
// Attend the first event on day 1.
// Attend the second event on day 2.
// Attend the third event on day 3.
// Example 2:

// Input: events= [[1,2],[2,3],[3,4],[1,2]]
// Output: 4
 

// Constraints:

// 1 <= events.length <= 105
// events[i].length == 2
// 1 <= startDayi <= endDayi <= 105

class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b) -> a[0]-b[0]);

        int day=0, idx=0, numberOfEvents=0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(!pq.isEmpty() || idx<n){
            if(pq.isEmpty()){
                day = events[idx][0];
            }

            while(idx<n && events[idx][0] <= day){
                pq.offer(events[idx][1]);
                idx++;
            }
            pq.poll();
            numberOfEvents++;
            day++; 
            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
        }
        return numberOfEvents;
    }
}