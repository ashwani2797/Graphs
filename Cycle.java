import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Graph
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
         if(v != w && !(adj[v].contains(w)))    // This will remove self-loops and parallel edges
          {
        this.adj[v].add(w);
        this.adj[w].add(v);
        this.E++;
         }
    }
1305i&me

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
class Ddfs
{
    boolean marked[];
    int edgeTo[];
    boolean isCycle;
    boolean check;
     Stack st= new Stack();

    public Ddfs(Graph G,int s)
    {
        int p=s;
        isCycle = false;
        check= false;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
               for(int i=0;i<G.V();i++)
            edgeTo[i] = Integer.MAX_VALUE;
        
        
        ddfs(G,s,-1);
    }

    private void ddfs(Graph G,int s,int p)
    {
        marked[s]=true;
        for(int W : G.adj(s))
        {
            if(! marked[W])
            {
                edgeTo[W]=s;
                ddfs(G,W,s);
            }
            else
            if(W != p )
                isCycle = true;
        }
    }
   
}
    
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int v,e;
        boolean iscycle = false;
        for(int j=0;j<t;j++){
            v = cin.nextInt();
            e = cin.nextInt();
            Graph G = new Graph(v);
            while(e > 0){
                G.addEdge(cin.nextInt(),cin.nextInt());
                e--;
            }
             for(int i=0;i<G.V();i++){
                  iscycle = false;
              Ddfs dfs = new Ddfs(G,i);
                if(dfs.isCycle == true){
                    iscycle = true;
                    break;
                    }
            }
            System.out.println(iscycle); 
            
        }
       
    }
}
