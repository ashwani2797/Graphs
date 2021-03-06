import java.io.*;
import java.util.*;

class Graph{
    private LinkedList<Integer>[] adj;
    private int E;
    private int V;
    
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for(int i=0 ; i<V ;i++)
            this.adj[i] = new LinkedList<Integer>();
    }
    
    public void addEdge(int a,int b){
        adj[b].add(a);
        adj[a].add(b);
        this.E++;
    }
    
    public int V(){
        return this.V;
    }
    
    public int E(){
        return this.E;
    }
    
    public Iterable<Integer> adj(int v){
        return this.adj[v];
    }
    
}

 class DFS{
    private int[] edgeTo;
    private boolean[] visited;
    
    public DFS( Graph G,int s){
        
        edgeTo = new int[G.V()];
        visited = new boolean[G.V()];
        for( int i=0; i<G.V() ;i++)
            this.edgeTo[i] = Integer.MAX_VALUE;
        dfs(G,s);
        
    }
    private void dfs(Graph G,int S){
        visited[S] = true;
        
        for(  Integer W : G.adj(S) ){
            if(!visited[W]){
                
                edgeTo[W]=S;
                dfs(G,W);
            }
                
            
        }
    }
    
    
}
public class Solution{
    
	public static void main(String[] args){
	    Scanner cin = new Scanner(System.in);
	    int t,v,e;
	/*   
     t = cin.nextInt();
	    
	    
	    for(int i=0;i<t;i++){
	        v = cin.nextInt();
	        e = cin.nextInt();
	        
	         Graph graph = new Graph(v);
	         for(int j=0 ; j<e ; j++)
	             graph.addEdge(cin.nextInt(),cin.nextInt());
	         
	         
	    }
	
	}
*/
}
}

