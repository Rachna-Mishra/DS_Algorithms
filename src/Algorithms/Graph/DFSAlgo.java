package Algorithms.Graph;

import java.util.ArrayList;

public class DFSAlgo {
    public void dfsOfGraph(ArrayList<Edge>[] graph, boolean[] vis){
        for(int i = 0; i< graph.length; i++){
            if(!vis[i]){
                dfs(graph, vis, i);
            }
        }
        System.out.println();
    }
    public void dfs(ArrayList<Edge>[] graph, boolean[] vis, int cur){
        System.out.print(cur+" ");
        vis[cur] = true;
        for(int i = 0; i< graph[cur].size(); i++){
            Edge e = graph[cur].get(i);
            if(!vis[e.des]){
                dfs(graph, vis, e.des);
            }
        }
    }
}
