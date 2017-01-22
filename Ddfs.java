import java.util.*;
class Ddfs
{
    boolean marked[];
    int edgeTo[];
    boolean isCycle;
    boolean check;
     Stack st= new Stack();

    public Ddfs(Dgraph G,int s)
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

    private void ddfs(Dgraph G,int s,int p)
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
    /*    G1 = new Dgraph(13);
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
        */
        G1 = new Dgraph(6);
        G1.addEdge(0,1);
        G1.addEdge(0,2);
        G1.addEdge(0,3);
       // G1.addEdge(3,0);
       
        G1.addEdge(0,4);
        G1.addEdge(0,5);
       
       
       G1.print(G1);
        G2=G1.reverse();
      //  System.out.println("*****************AFTER REVERSE**********");
       // G2.print(G2);
        boolean iscycle = false;
        for(int i=0;i<G1.V();i++){
              Ddfs dfs = new Ddfs(G1,i);
                if(dfs.isCycle == true){
                    iscycle = true;
                    break;
                    }
            }
        System.out.println("iscycle"+iscycle); 
      // dfs.printPath(0,2);
    }
 } 
