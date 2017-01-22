import java.util.LinkedList;

class Graph
{
    private LinkedList<Integer>[] adj;
    private int V;
    private int E;

    public Graph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for(int i=0;i<this.V;i++)
        {
           this.adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int a,int b)
    {
        this.adj[a].add(b);
        this.adj[b].add(a);
        this.E++;
    }
    public int V()
    {
        return this.V;
    }

    public int E()
    {
        return this.E;
    }

    public Iterable<Integer> adj(int V)
    {
        return this.adj[V];
    }
}

class DFS
{
    private boolean[] visited;
    private boolean[] color;
    private boolean red;
    private boolean isBipartite ;
    public DFS(Graph G,int S)
    {
        this.red = true;
        this.visited = new boolean[G.V()];
        this.color = new boolean[G.V()];
        this.color[S] = red;
        this.isBipartite = true;
        dfs(G,S);
    }
    private void  dfs(Graph G,int S)
    {
        visited[S] = true;
        for(Integer W: G.adj(S))
        {
            if(!visited[W])
            {
                color[W] = !color[S];
                dfs(G,W);
            }
            else
            {
                if(color[W] == color[S])
                    isBipartite = false;
            }    
        }
    }

    public boolean isBip()
    {
        return this.isBipartite;
    }
}
public class IsBipartite{
    
    public static void main(String[] args){
    int i;
     System.out.println("hello");
     Graph G = new Graph(9);
     G.addEdge(0,1);
     G.addEdge(1,2);
     G.addEdge(2,3);
     G.addEdge(3,4);
     G.addEdge(4,1);
     G.addEdge(5,6);
     G.addEdge(6,7);
     G.addEdge(7,8);
    // G.addEdge(5,7);
    boolean ispar = true;
    
  //   G.addEdge(2,4);
    for(i=0;i<G.V();i++){
    DFS dfs = new DFS(G,i);
    
    if(dfs.isBip() == false){
        ispar = false;
        break;
    }
    }
    System.out.println(ispar);

      
    }

 }
