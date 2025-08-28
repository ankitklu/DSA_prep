import java.util.*;
public class Sort_Matrix_by_Diagonals {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> arr = new ArrayList<>();
            int r = i, c = 0;
            while (r < n && c < n) {
                arr.add(grid[r][c]);
                r++;
                c++;
            }
            arr.sort((a, b) -> b - a);
            r = i;
            c = 0;
            int pos = 0;
            while (r < n && c < n) {
                grid[r][c] = arr.get(pos++);
                r++;
                c++;
            }
        }
        for (int i = 1; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            int r = 0, c = i;
            while (r < n && c < n) {
                arr.add(grid[r][c]);
                r++;
                c++;
            }
            arr.sort(Integer::compareTo);
            r = 0;
            c = i;
            int pos = 0;
            while (r < n && c < n) {
                grid[r][c] = arr.get(pos++);
                r++;
                c++;
            }
        }
        return grid;
    }
}
