import java.util.*;
public class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int mod=1000000007;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{1,1});
        int day=1;
        while(!q.isEmpty() && day<=n){
          int size=q.size();
          int cnt=0;
          while(size-->0){
            int node[]=q.poll();
            if(node[0]+forget>day){
                if(node[0]+delay<=day){
                    cnt=(cnt+node[1])%mod;
                }
                q.add(node);
            }
          }
          if(cnt>0){
            q.add(new int[]{day,cnt});
          }
          day++;
        }
        int ans=0;
        while(!q.isEmpty()){
            ans=(ans+q.poll()[1])%mod;
        }
        return ans;
    }
}