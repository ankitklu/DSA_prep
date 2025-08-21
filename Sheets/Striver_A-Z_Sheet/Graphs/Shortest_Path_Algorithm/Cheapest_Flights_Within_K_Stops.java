import java.util.*;
public class Cheapest_Flights_Within_K_Stops {
    static class Pair{
        int node;
        int wt;
        public Pair(int node, int wt){
            this.node =node;
            this.wt = wt;
        }
    }
    static class Tuple{
        int stops;
        int node;
        int cost;
        public Tuple(int stops, int node, int cost){
            this.stops= stops;
            this.node= node;
            this.cost= cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Pair>());
        }

        for(int edge[] : flights){
            int sr = edge[0];
            int dest = edge[1];
            int wt = edge[2];
            graph.get(sr).add(new Pair(dest, wt));
        }



        int dist[] = new int[n];

        for(int i=0;i<n;i++){
            dist[i]= i==src ? 0: Integer.MAX_VALUE;
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)-> a.cost-b.cost);
        pq.add(new Tuple(0, src, 0));
        while(!pq.isEmpty()){
            Tuple top = pq.poll();
            int stops = top.stops;
            int node = top.node;
            int cost = top.cost;

            if(stops>k){
                continue;
            }

            for(Pair curr: graph.get(node)){
                int neigh= curr.node;
                int wt = curr.wt;
                if(dist[neigh] > cost+wt){
                    dist[neigh] = cost + wt;
                    pq.add(new Tuple(stops+1, neigh, dist[neigh]));
                }
            }

        }
        return dist[dst]==Integer.MAX_VALUE? -1: dist[dst];
    }
}
