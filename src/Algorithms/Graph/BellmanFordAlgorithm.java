package Algorithms.Graph;

public class BellmanFordAlgorithm {
    //Dynamic Programming Approach - O(E.V)
    //Working for both positive and negative weights
    // Failed in case of negative weight cycle (wt[a]+wt[b]+wt[c] < 0) that means negative weight cycle present
    //in that case finding shortest path is of no sense
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        for(int i = 0; i<V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i<V-1; i++){
            for(int j = 0; j < edges.length; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                if(dist[u]!= Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        //FOR CHECKING NEGATIVE WT CYCLE - JUST RUN SAME LOOP 1 MORE TIME, IF UPDATION STILL THAT MEANS
        // NEGATIVE WT CYCLE PRESENT

        boolean negativeWtCycle = false;
        for(int j = 0; j < edges.length; j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];
            if(dist[u]!= Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                negativeWtCycle = true;
                dist[v] = dist[u] + wt;
            }
        }
        if(negativeWtCycle){
            return new int[]{-1};
        }
        return dist;
    }

}
