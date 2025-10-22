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
