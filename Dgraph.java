import java.util.LinkedList;

public class Dgraph
{
    private LinkedList<Integer>[] adj;
    private int V;
    private int E;

    public Dgraph(int V)
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

    public Dgraph reverse()
    {
        Dgraph G2 = new Dgraph(this.V());
        for(int i=0;i<this.V();i++)
        {
            for(int j : this.adj(i))
                  G2.addEdge(j,i);   
        }
    return G2;
    }

    public void print(Dgraph G)
    {
        for(int i=0;i<G.V();i++)
        {
            System.out.print(i+": ");
            for(int j: G.adj(i))
                System.out.print(j+" ");
        System.out.println();
        }
        System.out.println();
    }   
   


}
