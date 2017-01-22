import java.util.LinkedList;
class Graph
{
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int v)
    {
        this.V=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<Integer>();
        this.E=0;
    }
    
    public void addEdge(int v,int w)
    {
        this.adj[v].add(w);
        this.adj[w].add(v);
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
