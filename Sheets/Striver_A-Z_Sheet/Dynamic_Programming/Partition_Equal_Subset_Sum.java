import java.util.*;
public class Partition_Equal_Subset_Sum {
    public boolean helper(int nums[],int dp[][] ,int index,int target){
        if(target==0){
            return true;
        }
        if(index==nums.length){
            return target==0;
        }
        if(dp[index][target]!=-1){
            return dp[index][target] == 0 ? false : true;
        }

        boolean notPick= helper(nums,dp, index+1, target);
        boolean pick= false;
        if(nums[index]<=target){
            pick= helper(nums,dp, index+1, target-nums[index]);
        }

        dp[index][target]= notPick || pick?1:0;
        return notPick||pick;
    }
    public boolean canPartition(int[] nums) {
        
        int target= 0;
        for(int num: nums){
            target+=num;
        }
        if(target%2!=0){
            return false;
        }
        int dp[][]=new int[nums.length][(target/2)+1];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        return helper(nums,dp, 0,target/2);
    }    
}
