import java.util.*;
public class BFS
{
    private boolean[] marked;
  //  private int s;
    private int[] edgeTo;
    public BFS(Graph G,int s)
    {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        for(int i = 0;i < G.V();i++)
            this.edgeTo[i] =Integer.MAX_VALUE;
        bfs(G,s);   
    }

    private void bfs(Graph G,int S){
        int W;
        marked[S] = true;
        Queue<Integer> q = new LinkedList();
        q.add(S);
        while(! q.isEmpty() )
         {
            W=q.remove();
            for(Integer V : G.adj(W))
             {
                if(!marked[V])
                 {
                    marked[V] = true;
                    edgeTo[V] = W;
                    q.add(V);
                 }
             }
         }
    }
       public void printPath(int src,int dest){
         
        while(edgeTo[dest] != src){
       
            System.out.print(dest);
            dest = edgeTo[dest];
            }
            
            System.out.print(dest);
            
            System.out.print(src);
    }

public static void main(String[] args){
  
        Graph graph = new Graph(7);
        graph.addEdge(0,4);
        graph.addEdge(0,2);
        graph.addEdge(0,5);
        graph.addEdge(4,3);
        graph.addEdge(3,2);
      //  graph.addEdge(1,1);
      //  graph.addEdge(6,7);
   
        BFS bf = new BFS(graph,0);
        bf.printPath(0,2);      



    }

}
