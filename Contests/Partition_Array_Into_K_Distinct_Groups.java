package Contests;
import java.util.*;

public class Partition_Array_Into_K_Distinct_Groups {
    public boolean partitionArray(int[] nums, int k) {
        if(nums.length%k!=0){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int maxEle = 0;
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
            if(map.get(num) > nums.length/k){
                return false;
            }
        }
        return nums.length%k==0;

    }
}
