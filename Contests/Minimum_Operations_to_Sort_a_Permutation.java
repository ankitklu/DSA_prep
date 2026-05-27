class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        int ind=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                ind=i;
                break;
            }
        }
        boolean front=true;
        boolean back=true;
        for(int i=1;i<n;i++){
            if(nums[(ind+i)%n]!=i){
                front=false;
                break;
            }
        }
        for(int i=1;i<n;i++){
            if(nums[(ind-i+n)%n]!=i){
                back=false;
                break;
            }
        }
        if(!front&&!back){
            return -1;
        }
        int res=Integer.MAX_VALUE;
        if(front){
            if(ind==0){
                res=0;
            }
            else{
                res=Math.min(res,ind);
                res=Math.min(res,n-ind+2);
            }
        }
        if(back){
            res=Math.min(res,n-ind);
            res=Math.min(res,ind+2);
        }
        return res;
    }
}

// 2, 0, 1, 3
// 0, 1, 2, 3


// 2, 0, 1, 3
// 3, 2, 1, 0

// 3, 4, 0, 1, 2

// 1, 2, 3, 4, 0

// 0, 4, 3, 2, 1
// 4, 3, 2, 1, 0
// 
