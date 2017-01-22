import java.util.*;
public class Dbfs
{
    private boolean[] marked;
  //  private int s;
    private int[] edgeTo;
    Stack st = new Stack();
    public Dbfs(Dgraph G,int s)
    {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        for(int i = 0;i < G.V();i++)
            this.edgeTo[i] =Integer.MAX_VALUE;
        bfs(G,s);   
    }

    private void bfs(Dgraph G,int S){
        int W;
        marked[S] = true;
        Queue<Integer> q = new LinkedList();
        q.add(S);
        while(! q.isEmpty() )
         {
            W=q.remove();
            for(Integer V : G.adj(W))
             {
                if(!marked[V])
                 {
                    marked[V] = true;
                    edgeTo[V] = W;
                    q.add(V);
                 }
             }
         }
    }
     public void printPath(int src,int dest){
         
        while(edgeTo[dest] != src){
            st.push(dest);
             dest = edgeTo[dest];
            }
            st.push(dest);
            st.push(src);
            while(!st.isEmpty())
               System.out.print(st.pop()+"--> ");
    }
    

    public static void main(String[] args)
    {
        Dgraph G1,G2;
        G1 = new Dgraph(13);
        G1.addEdge(0,1);                     
        G1.addEdge(0,5);                     
        G1.addEdge(2,0);                     
        G1.addEdge(2,3);                     
        G1.addEdge(3,2);                     
        G1.addEdge(3,5);                     
        G1.addEdge(4,2);                     
        G1.addEdge(5,4);                     
        G1.addEdge(6,8);                     
        G1.addEdge(6,0);                     
        G1.addEdge(6,4);                     
        G1.addEdge(6,9);                     
        G1.addEdge(7,6);                     
        G1.addEdge(7,9);                     
        G1.addEdge(8,6);                     
        G1.addEdge(9,10);                     
        G1.addEdge(9,11);                     
        G1.addEdge(10,12);                     
        G1.addEdge(11,4);                     
        G1.addEdge(11,12);                     
        G1.addEdge(12,9);
        G1.print(G1);
        G2=G1.reverse();
        System.out.println("*****************AFTER REVERSE**********");
        G2.print(G2);
       Dbfs bfs = new Dbfs(G1,0); 
       bfs.printPath(0,2);
    }
}
