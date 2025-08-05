package Sheets.Being_Zero.Stack_Queue;

import java.util.*;

public class Jumping_Numbers {

    public void printJumpingNumbers(int n) {
        if (n < 0) {
            System.out.println(); // Just a newline
            return;
        }

        Deque<Integer> dq = new ArrayDeque<>();

        if (n <= 10) {
            for (int i = 0; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        // Print 0 to 9 and add 1 to 9 into deque
        for (int i = 0; i <= 9; i++) {
            System.out.print(i + " ");
            if (i != 0) {
                dq.addLast(i);
            }
        }

        // BFS-like traversal using deque
        while (!dq.isEmpty()) {
            int num = dq.pollFirst();

            int lastDigit = num % 10;

            if (lastDigit != 0) {
                int num1 = num * 10 + (lastDigit - 1);
                if (num1 <= n) {
                    System.out.print(num1 + " ");
                    dq.addLast(num1);
                }
            }

            if (lastDigit != 9) {
                int num2 = num * 10 + (lastDigit + 1);
                if (num2 <= n) {
                    System.out.print(num2 + " ");
                    dq.addLast(num2);
                }
            }
        }

        System.out.println(); // For clean output
    }
}
