import java.util.*;

class number
{
    boolean visited[];
    int path[];
    int index;
    int count;
    public number(Dgraph G,int s,int d)
    {
        index = 0;
        count=0;
        visited = new boolean[G.V()];
        path = new int[G.V()];
        numb(G,s,d);
        System.out.println("No. of paths"+count);
     }

    private void numb(Dgraph G,int u,int d)
    {
        visited[u] = true;
        path[index] = u;
        index++;
    
        if( u == d)
        {
            count++;
            for(int i = 0;i<index;i++)
                System.out.print(path[i]+" ");
                System.out.println();
        }
        else
        {
             for(int W : G.adj(u)){
                if( ! visited[W])
                    numb(G,W,d);
                }
        }
    index--;
    visited[u] = false;
    }

}
public class noOFpaths{

    public static void main(String[] args){
        Dgraph G= new Dgraph(4);
        G.addEdge(2,0);
        G.addEdge(2,1);
        G.addEdge(0,2);
        G.addEdge(0,3);
        G.addEdge(0,1);
        G.addEdge(1,3);
        number no = new number(G,2,3);       

      }
}

