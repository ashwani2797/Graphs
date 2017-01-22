import java.util.*;
public class DFS
{
    private boolean[] marked;
  //  private int s;
    private int[] edgeTo;
    Stack st=new Stack();
  
    public DFS(Graph G,int s)
    {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        for(int i = 0;i < G.V();i++)
            this.edgeTo[i] =Integer.MAX_VALUE;
        dfs(G,s);   
    }

    private void dfs(Graph G,int V)
    {
        marked[V]=true;
        System.out.println("Next-->"+V);
        for(Integer W : G.adj(V))
        {
            if(!marked[W])
            {
                edgeTo[W] = V;
                dfs(G,W);
            }
        }
        System.out.println("children exausted"+V);
    }

    public boolean hasPathTo(int w)
    {
        return marked[w];
    }
    
    public void printPath(int src,int dest){
         
        while(edgeTo[dest] != src){
            st.push(dest);
            //System.out.print(dest);
            dest = edgeTo[dest];
            }
            st.push(dest);
            //System.out.print(dest);
            st.push(src);
            //System.out.print(src);
            while(!st.isEmpty())
               System.out.print(st.pop()+"--> ");
    }

    public void arr(){
        System.out.println();
        for(int i=0;i<edgeTo.length;i++)
            System.out.print(edgeTo[i]+" ");
        System.out.println();
    }
    public static void main(String[] args )
    {
        
        Graph graph = new Graph(7);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(1,3);
        graph.addEdge(1,2);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
      //  graph.addEdge(1,1);
      //  graph.addEdge(6,7);
   
        DFS df = new DFS(graph,0);
        df.arr();
        df.printPath(0,2);
     //   System.out.println("Path to 3 --> " + df.hasPathTo(3));       
      //  System.out.println("Path to 2 --> " + df.hasPathTo(2));       
    }

}
