class dfs
{
    boolean visited[];
    int rescount;
    public dfs(Dgraph G,int S){
        rescount =  0;
        visited = new boolean[G.V()];
       
        dfsutil(G,S,S,0);
        }


    private void dfsutil(Dgraph G,int S,int M,int count)
    {
        visited[M] = true;
        for( int W : G.adj(M)){
            if( !visited[W])    
                dfsutil(G,S,W,count+1);
            else
            {
                if(W == S){
                    if( count > rescount)
                        rescount = count;
                }
            }
        }
    }

    public int display(){
        return rescount;  
     }   
}
public class LargestCycle
{
    public static void main( String[] args){
        Dgraph G = new Dgraph(6);
        G.addEdge(0,1); 
        G.addEdge(1,2); 
        G.addEdge(2,4); 
        //G.addEdge(2,0); 
        G.addEdge(4,3); 
       // G.addEdge(3,0); 
        G.addEdge(3,5); 
        G.addEdge(5,4); 
        //G.addEdge(6,0); 
       boolean optimize[] =new boolean[G.V()];
        for(int i=0;i< G.V();i++){
            for(int W : G.adj(i)){
                if(! optimize[W])
                    optimize[W] = true;
             }
        }
       int res = 0,rescount; 
       for( int i=0;i<G.V();i++){
            if( optimize[i]){
                dfs d =new dfs(G,i);
                rescount = d.display();
                if( res < rescount)
                res = rescount;
                }
       }
     System.out.println(res); 
    }
 }

    
      
