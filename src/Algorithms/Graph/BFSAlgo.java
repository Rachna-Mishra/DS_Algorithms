package Algorithms.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSAlgo {
    public void bfsOfGraph(ArrayList<Edge>[] graph, boolean[] vis){
        for(int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfs(graph, vis, i);
            }
        }
        System.out.println();
    }
    public void bfs(ArrayList<Edge>[] graph, boolean[] vis, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int cur = queue.remove();
            if(!vis[cur]){
                System.out.print(cur+" ");
                vis[cur] = true;
                for(int i = 0; i < graph[cur].size(); i++){
                    Edge e = graph[cur].get(i);
                    queue.add(e.des);
                }
            }
        }
    }
}
