package Algorithms.Graph;

import java.util.ArrayList;

public class PrintAllPath {
    public void printAllPathsFromSrcToDes(ArrayList<Edge> graph[], boolean[] vis, int cur, int tar, String path){
        if(cur == tar){
            System.out.println(path);
            return;
        }
        for(int i = 0; i < graph[cur].size(); i++){
            Edge e = graph[cur].get(i);
            if(!vis[cur]) {
                vis[cur] = true;
                printAllPathsFromSrcToDes(graph, vis, e.des, tar, path + e.des);
                vis[cur] = false;
            }
        }
    }
}
