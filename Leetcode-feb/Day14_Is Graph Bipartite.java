/*
Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split its set of nodes into two independent subsets A and B,
such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.
Each node is an integer between 0 and graph.length - 1. There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can divide the vertices into two groups: {0, 2} and {1, 3}.

Example 2:


Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: We cannot find a way to divide the set of nodes into two independent subsets.
*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        int [] color = new int[graph.length];
        for(int i=0; i<color.length;++i){
            if(color[i]==0){
                Queue<Integer> bfs = new LinkedList<>();
                bfs.add(i);
                color[i]=1;
                while(!bfs.isEmpty()){
                    int prev = bfs.remove();
                    int nextColor = -color[prev];
                    int[] children = graph[prev];
                    for(int j=0; j<children.length;++j){
                        int next = children[j];
                        if(color[next]==0){
                            bfs.add(next);
                            color[next]=nextColor;
                        }
                        else if(color[next]!=nextColor){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}