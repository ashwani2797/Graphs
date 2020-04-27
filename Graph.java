import java.util.LinkedList;

public class Graph
{
    private LinkedList<Integer>[] adj;
    private int V;
    private int E;

    public Graph(int V)
    {
        this.V = V;
        adj = new LinkedList[V];
        for( int i = 0;i < V; i++)
            this.adj[i] = new LinkedList<Integer>();
        this.E = 0;
    }

    public void addEdge(int v,int w)
    {
        this.adj[v].add(w);
        this.adj[w].add(v);
        this.E++;
        //helo

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
