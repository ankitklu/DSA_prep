import java.util.*;
public class Find_the_Number_of_Ways_to_Place_People_II {
    public int numberOfPairs(int[][] points) {
        int ways = 0;
        int n = points.length;

        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                if(a[0] == b[0]) return Integer.compare(b[1], a[1]);
                return Integer.compare(a[0], b[0]);
            }
        });

        for(int i=0;i<n-1;i++){
            int A[] = points[i];
            int maxi = A[1];
            int mini = Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                int B[] = points[j];
                if(B[1] > mini && B[1] <= maxi){
                    ways++;
                    mini = B[1];
                }
            }
        }
        
        return ways;
    }
}
