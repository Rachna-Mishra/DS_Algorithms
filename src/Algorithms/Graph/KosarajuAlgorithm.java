package Algorithms.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class KosarajuAlgorithm {
    // Function to find number of strongly connected components in the graph.
    /*This is finding Strongly connected components(which means we can reach every vertex of component
    from every other vertex in that component)
    // This is applicable only in Directed Algorithms.Graph
    // There is no sense of finding scc in undirected graph that is only 1 scc
     */
    //Step1 - Add all nodes in stack using topological sort
    //Step2 - Transpose the graph(Change direction of each edge )
    //Step3 - Apply dfs on transpose graph using stack nodes formed in step 1
    // Time complexity for each step (V+E) so overall is O(V+E)
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int count = 0;
        int V = adj.size();
        boolean[] vis = new boolean[V];

        //Step1- Build Stack using Topological Sort
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                topSort(i, adj, vis, stack);
            }
        }

        //Step2 - Transpose Algorithms.Graph
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i = 0; i<V; i++){
            transpose.add(new ArrayList<Integer>());
        }
        transposeGraph(V, adj, transpose);

        //Step3 - Apply dfs
        Arrays.fill(vis, false);
        while(!stack.isEmpty()){
            int curNode = stack.pop();
            if(!vis[curNode]){
                dfs(curNode, transpose, vis);
                count++;
            }
        }
        return count;
    }

    public void topSort(int cur, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack){
        vis[cur] = true;
        for(int i = 0; i<adj.get(cur).size(); i++){
            int neighbour = adj.get(cur).get(i);
            if(!vis[neighbour]){
                topSort(neighbour, adj, vis, stack);
            }
        }
        stack.add(cur);
    }

    public void transposeGraph(int V, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> transpose){
        for(int i = 0; i<V; i++){
            for(int j = 0; j<adj.get(i).size(); j++){
                int des = adj.get(i).get(j);
                transpose.get(des).add(i);
            }
        }
    }

    public void dfs(int cur, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[cur] = true;
        for(int i = 0; i<adj.get(cur).size(); i++){
            int neighbour = adj.get(cur).get(i);
            if(!vis[neighbour]){
                dfs(neighbour, adj, vis);
            }
        }
    }

}
