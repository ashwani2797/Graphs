import java.util.*;
class BFS
{
    private boolean[] marked;
    private int[] edgeTo;

    public BFS(Graph G,int S)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for(int i=0;i<G.V();i++)
            edgeTo[i]=Integer.MAX_VALUE;
        bfs(G,S);
    }
    
    private void bfs(Graph G,int S)
    {
        int W;
        Queue <Integer>que = new LinkedList();
        que.add(S);    
        marked[S]=true;
        while(!que.isEmpty())
        {
            W= que.remove();
            for(int V: G.adj(W))
            {
                if(! marked[V])
                {
                    que.add(V);
                    edgeTo[V]=W;
                    marked[V] = true;
                }
            }
        }
    }

    private boolean  hasPathTo(int d)
    {
        return marked[d];
    }

    public static void main(String[] args)
    {
        Graph graph=new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
        
    
        BFS bf=new BFS(graph,0);
        System.out.println(bf.hasPathTo(4));  
          
        //System.out.println(df.hasPathTo(5));  
    } 

}
                        
