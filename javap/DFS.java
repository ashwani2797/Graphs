class DFS
{
    private boolean[] marked;
    private int[] edgeTo;
    
    public DFS(Graph G,int S)
    {
        marked=new boolean[G.V()];
        edgeTo = new int[G.V()];
        for(int i=0;i<G.V();i++)
            edgeTo[i] = Integer.MAX_VALUE;
        dfs(G,S);
    }

    private void dfs(Graph G,int S)
    {
        marked[S]=true;
        for(int W: G.adj(S))
        {
            if(!marked[W])
            {
                edgeTo[W]=S;
                dfs(G,W);
            }
         }
    }
    private boolean hasPathTo(int d)
    {
        return marked[d];
    }


    public static void main(String[] args)
    {
        Graph graph=new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
        
    
        DFS df=new DFS(graph,0);
        System.out.println(df.hasPathTo(3));  
          
        //System.out.println(df.hasPathTo(5));  
    } 
}
   
