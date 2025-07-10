import java.util.*;
public class Reschedule_Meetings_for_Maximum_Free_Time_II {
    
}
 
/*
 * 3440. Reschedule Meetings for Maximum Free Time II

avatar
Discuss Approach
arrow-up
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer eventTime denoting the duration of an event. You are also given two integer arrays startTime and endTime, each of length n.

These represent the start and end times of n non-overlapping meetings that occur during the event between time t = 0 and time t = eventTime, where the ith meeting occurs during the time [startTime[i], endTime[i]].

You can reschedule at most one meeting by moving its start time while maintaining the same duration, such that the meetings remain non-overlapping, to maximize the longest continuous period of free time during the event.

Return the maximum amount of free time possible after rearranging the meetings.

Note that the meetings can not be rescheduled to a time outside the event and they should remain non-overlapping.

Note: In this version, it is valid for the relative ordering of the meetings to change after rescheduling one meeting.

 

Example 1:

Input: eventTime = 5, startTime = [1,3], endTime = [2,5]

Output: 2

Explanation:



Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].

Example 2:

Input: eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]

Output: 7

Explanation:



Reschedule the meeting at [0, 1] to [8, 9], leaving no meetings during the time [0, 7].

Example 3:

Input: eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]

Output: 6

Explanation:



Reschedule the meeting at [3, 4] to [8, 9], leaving no meetings during the time [1, 7].

Example 4:

Input: eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]

Output: 0

Explanation:

There is no time during the event not occupied by meetings.

 

Constraints:

1 <= eventTime <= 109
n == startTime.length == endTime.length
2 <= n <= 105
0 <= startTime[i] < endTime[i] <= eventTime
endTime[i] <= startTime[i + 1] where i lies in the range [0, n - 2].
 */
class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        List<Integer> free = new ArrayList<>();
        free.add(startTime[0]);

        for(int i=1;i<startTime.length;i++){
            free.add(startTime[i]-endTime[i-1]);
        }
        free.add(eventTime-endTime[endTime.length-1]);

        int pre[]= new int[free.size()];
        int suff[]= new int[free.size()];

        for(int i=free.size()-2;i>=0;i--){
            suff[i]= Math.max(suff[i+1],free.get(i+1));
        }
        for(int i=2;i<free.size();i++){
            pre[i] = Math.max(pre[i-1], free.get(i-2));
        }

        int max=0;
        for(int i=1;i<free.size();i++){
            int meet= endTime[i-1] - startTime[i-1];
            if(meet <= Math.max(pre[i], suff[i])){
                max = Math.max(max, free.get(i-1)+free.get(i)+meet);
            }
            max= Math.max(max, free.get(i-1)+free.get(i));
        }
        return max;
    }
}
