import java.util.*;
// https://read.learnyard.com/online-assessment-dsa-questions/flipkart/networking-company-sequence-selection/
public abstract class Flipkart_OA2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt(); 
        int N = sc.nextInt(); 

        int[][] msgGrid = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                msgGrid[i][j] = sc.nextInt();
            }
        }

        int[] maxPerDevice = new int[N];
        Arrays.fill(maxPerDevice, Integer.MIN_VALUE);

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                maxPerDevice[j] = Math.max(maxPerDevice[j], msgGrid[i][j]);
            }
        }

        int[] leadCount = new int[M];
        double[] avgCount = new double[M];

        for (int i = 0; i < M; i++) {
            long sum = 0;
            int count = 0;
            for (int j = 0; j < N; j++) {
                sum += msgGrid[i][j];
                if (msgGrid[i][j] == maxPerDevice[j]) {
                    count++;
                }
            }
            leadCount[i] = count;
            avgCount[i] = (double) sum / N;
        }

        int bestSeq = 0;
        int bestLead = leadCount[0];
        double bestAvg = avgCount[0];

        for (int i = 1; i < M; i++) {
            if (leadCount[i] > bestLead) {
                bestLead = leadCount[i];
                bestSeq = i;
                bestAvg = avgCount[i];
            } else if (leadCount[i] == bestLead) {
                if (avgCount[i] > bestAvg) {
                    bestSeq = i;
                    bestAvg = avgCount[i];
                }
            }
        }

        System.out.println(bestSeq + " " + bestLead);
    }
}

/*
 * Problem Description
A networking company is implementing procedures to manage network traffic. The network server is connected to N devices (numbered from 0 to N-1). The server receives messages from each of these N devices, which are then transmitted in different possible sequences.

The team has generated M possible sequences of message counts from the devices, and one of these sequences will be chosen for the initial iteration. In each sequence, there is a specific count of messages selected for each device.

Objective: Identify the sequence to use, based on the following criteria:

For each device, determine the maximum message count across all sequences.
Select the sequence that contains this maximum message count for the highest number of devices.
If multiple sequences meet this criterion, select the sequence with the highest average message count.
Input Format:
The first line contains two space-separated integers:
msgGrid_row (M): The number of sequences.
msgGrid_col (N): The number of devices.
The next M lines consist of N space-separated integers representing the count of messages for each device in a sequence.
Output Format:
Print two space-separated integers representing:
The ID of the selected sequence.
The number of devices for which the count of messages is highest in that sequence.
Constraints:
0 < msgGrid_row, msgGrid_col < 10^4
0 <= count of messages for a device in a sequence <= 10^4
Example:
Input:

4 5
7 2 6 6 14
1 4 2 3 17
1 2 3 4 17
1 1 5 0 9
Output:

1 2
Explanation:

Maximum count of messages for each device among all sequences:
Device 0: 7 (from sequence 0)
Device 1: 4 (from sequence 1)
Device 2: 6 (from sequence 0)
Device 3: 6 (from sequence 0)
Device 4: 17 (from sequences 1 and 2)
Step 1: Determine maximum counts per sequence:
Sequence 0: Highest for 3 devices (Devices 0, 2, and 3).
Sequence 1: Highest for 2 devices (Devices 1 and 4).
Sequence 2: Highest for 1 device (Device 4).
Sequence 3: Highest for 0 devices.
Step 2: Average of counts (if tie-breaking is needed):
Sequence 0: Average = (7 + 2 + 6 + 6 + 14) / 5 = 7
Sequence 1: Average = (1 + 4 + 2 + 3 + 17) / 5 = 5.4
Since sequence 0 has the highest count of messages for 3 devices, it is selected. Thus, the output is 0 3.


 */