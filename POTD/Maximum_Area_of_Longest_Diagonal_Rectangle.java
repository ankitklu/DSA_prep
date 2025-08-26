public class Maximum_Area_of_Longest_Diagonal_Rectangle {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int[] best = new int[2];
        for (int[] d : dimensions) {
            int p = d[0] * d[0] + d[1] * d[1];
            if (p > best[0] || (p == best[0] && d[0] * d[1] > best[1])) {
                best[0] = p;
                best[1] = d[0] * d[1];
            }
        }

        return best[1];
    }
}
