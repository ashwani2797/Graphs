import java.util.*;

class Graph{
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int V){
        adj = new LinkedList[V];
        this.V = V;
        this.E = E;
        for( int i = 0; i < V ; i++)
            adj[i] = new LinkedList<>();
       }

    public void addEdge(int a,int b){
        adj[a].add(b); 
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    public Iterable<Integer> adj(int V){
        return this.adj[V];
    }
}

class DFS{
    private boolean[] visited;
    Stack st = new Stack();

    public DFS(Graph G,int S){
        visited = new boolean[G.V()];
        
        dfs(G,S);
    }
    public void dfs(Graph G,int S){
        
        if(visited[S] == false){        
        visited[S] = true;
        for(Integer W : G.adj(S)){
            
                if( !visited[W]) 
                    dfs(G,W);
                                            
            }
     st.add(S);   
    }
   }

}
public class TopoSort{

    
    public static void main(String[] args){
     
        Graph G = new Graph(7);
        G.addEdge(0,2);
        G.addEdge(1,2);
        G.addEdge(2,3);
        G.addEdge(1,4);
        G.addEdge(3,5);
        G.addEdge(4,5);
        G.addEdge(5,6);
        DFS Dfs = new DFS(G,0);

        for(int i=1;i<G.V();i++)
            Dfs.dfs(G,i);

        while(!Dfs.st.isEmpty() ){
            System.out.println(Dfs.st.pop());
            }
}
}
