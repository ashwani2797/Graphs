
class BST{

    Node root = null;

    class Node{
        int key;
        Node left;
        Node right;

        public Node(int key){
         this.key = key;   
         this.left = null;
         this.right = null;
        }

    }
    public void insert(int key){

    root = insert(root,key);

    }

    private Node insert(Node n,int key){
        if( n == null)
            return new Node(key);

        if(key < n.key )
            n.left = insert(n.left, key);
        else if(key > n.key)
            n.right = insert(n.right,key);  
        

    return n;
    }
    public void inorder(){
        inorder(root);
    }
    private void inorder(Node n){
        if(n == null)
            return; 

     

        inorder(n.left);
               inorder(n.right);
   System.out.print(n.key + " ");
    }


    public static void main(String[] args){
        System.out.println("hello");
        BST tree = new BST();
        tree.insert(15);
        tree.insert(8);
        tree.insert(20);
        tree.insert(4);
        tree.insert(10);
        tree.insert(17);
        tree.insert(25);
        tree.inorder();

    }


}
