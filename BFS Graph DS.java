import java.util.*;
class BFSnDFSGraph{
    static class Edge{
        int src;
        int des;
        //int wt;

        public Edge(int s,int d){
            this.src = s;
            this.des = d;
            //this.wt = wt;
        }
    }

    // Graph Structure
    //            1-------3
    //           /        | \
    //          /         |  \
    //         0          |   \
    //          \         |    5------6
    //           \        |   /
    //            \       |  /
    //             \      | /
    //              2------4

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    public static void BFS(ArrayList<Edge> graph[],int V){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        for(int i=0;i<visited.length;i++){
            visited[i] = false;
        }

        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(visited[curr] != true){
                System.out.print(curr+" ");
                visited[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge vertex = graph[curr].get(i);
                    q.add(vertex.des);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] vis){
        System.out.print(curr+" ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.des]==false){
                dfs(graph,e.des,vis);
            }
        }

    }

    public static void printAllPaths(ArrayList<Edge> graph[],int curr, boolean[] vis,int tar,String path){
        if(curr == tar){
            System.out.println(path);
            return;
        }

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.des] == false){
                vis[curr] = true;
                printAllPaths(graph,e.des,vis,tar,path+e.des);
                vis[curr] = false;
            }
        }
    }

    public static void main(String[] args){
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        BFS(graph,V);

        // output: 0,1,2,3,4,5,6

        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            vis[i] = false;
        }
        System.out.println();
        dfs(graph,0,vis);

        // output: 0,1,3,4,2,5,6

        System.out.println("\n----------------------");
        //vis[0] = true;
        boolean[] vis2 = new boolean[V];
        for(int i=0;i<V;i++){
            vis[i] = false;
        }
        printAllPaths(graph,0, vis2, 5, "0");



    }
}