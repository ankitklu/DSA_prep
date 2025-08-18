import java.util.*;
public class Find_Eventual_Safe_States {
    public List<Integer> eventualSafeNodes(int[][] arr) {
        List<List<Integer>> graph = new ArrayList<>();
        int nodes = arr.length;
        for(int i=0;i<arr.length;i++){
            graph.add(new ArrayList<>());
        }

        int indegree[] = new int[nodes];

        for(int i=0;i<nodes;i++){
            int src = i;
            for(int j=0;j<arr[i].length;j++){
                graph.get(arr[i][j]).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<nodes;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        List<Integer> ans=  new ArrayList<>();
        
        while(!q.isEmpty()){
            int top = q.poll();
            ans.add(top);
            
            for(int neigh: graph.get(top)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        Collections.sort(ans);
        return ans;

    }
}

