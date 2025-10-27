import java.util.*;

public class Zomato_OA_1 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(maxAs(n));
    }

    public static int maxAs(int N) {
        if (N <= 6) return N;

        int[] dp = new int[N + 1];
        for (int i = 1; i <= 6; i++) dp[i] = i;

        for (int i = 7; i <= N; i++) {
            dp[i] = 0;
            for (int j = i - 3; j >= 1; j--) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }


        return dp[N];
    }
}
/*
 * Problem Description
Imagine you have a special typing machine with the following keys:

Key 1: Prints the letter 'A' on the screen.

Key 2: (Ctrl-A) Selects everything that has been printed on the screen.

Key 3: (Ctrl-C) Copies the selected content to a clipboard.

Key 4: (Ctrl-V) Pastes the clipboard content onto the screen, appending it to the existing text.

Determine the maximum number of 'A's that can appear on the screen by pressing the keys on this special machine exactly N times.

Constraints:
1 < N < 76

Example 1:

Input:
N = 3

Output:
3

Explanation: Press Key 1 three times to get three 'A's on the screen.

Example 2:

Input:
N = 7

Output:
9

Explanation: The optimal sequence is to press Key 1 three times, then Key 2, Key 3, and finally press Key 4 twice.
 */
