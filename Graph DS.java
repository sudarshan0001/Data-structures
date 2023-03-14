import java.util.*;
class GraphDS {

    static class Edge{
        int src;
        int des;

        public Edge(int s,int d){
            this.src = s;
            this.des = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        //array will be containing null values 
        // null values cannot be directed populated with edge data 
        //So at first we have to add arraylist in each index of the array
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        //add each edge into the array list 
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
    }

    public static void main(String[] args){
        int N = 4;
        ArrayList<Edge> graph[] = new ArrayList[N];

        //call build/create graph
        createGraph(graph);

        //finding neighbours
        for(int i=0;i<graph[2].size();i++){
            int neighbours = graph[2].get(i).des;
            System.out.print(neighbours+" ");
        }
    }
}
