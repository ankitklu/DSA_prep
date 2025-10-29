import java.util.*;
// https://read.learnyard.com/online-assessment-dsa-questions/flipkart/conference-schedule/
public class Flipkart_OA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            end[i] = sc.nextInt();
        }

        System.out.println(maxSessions(start, end, n));
    }

    public static int maxSessions(int[] start, int[] end, int n) {
        int[][] sessions = new int[n][2];
        for (int i = 0; i < n; i++) {
            sessions[i][0] = start[i];
            sessions[i][1] = end[i];
        }

        Arrays.sort(sessions, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEndTime = -1;

        for (int i = 0; i < n; i++) {
            if (sessions[i][0] >= lastEndTime) {
                count++;
                lastEndTime = sessions[i][1];
            }
        }

        return count;
    }
}

/*
 * Problem Description
A schedule for an upcoming tech conference has been released, listing the start and end times of each session. Once a session begins, attendees cannot enter or leave the room. Moving between sessions takes no time.

The task is to determine the maximum number of sessions a single attendee can attend.

Input Format:
The first line contains an integer n, the number of presentations.
The second line contains n space-separated integers representing the start times of the presentations.
The third line contains n space-separated integers representing the end times of the presentations.
Output Format:
Print a single integer representing the maximum number of presentations that one person can attend.
Constraints:
1 <= n <= 10^5
1 <= scheduleStart[i], scheduleEnd[i] <= 10^9
Example:
Input:

3
1 1 2
3 2 4
Output:

2
Explanation:

Using 0-based indexing:

An attendee can attend presentation 1 (starting at 1, ending at 2) and presentation 2 (starting at 2, ending at 4).
Presentation 0 (starting at 1, ending at 3) overlaps with presentation 1 and 2, so it cannot be attended along with any other presentation.
Thus, the maximum number of presentations that can be attended is 2.
 */
