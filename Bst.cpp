#include<iostream>

using namespace std;

class Node{

    Node *left;
    Node *right;
    int key;
    public Node(int key){
        this->key = key;
        this->left =NULL;
        this->right = NULL;
   } 
}

class BST  {

    Node *root = NULL;

    public void insert(int key){
        root = insert(root,key);
    } 
    private Node insert(Node *n,int key){
        if(n==NULL) return new Node(key);
        if(key < n->key ) n->left = insert(n->left,key);
        else if(key > n->key) n->right = insert(n->right,key);
        return n;
      }  

}


int main()
{
    BST tree;
    tree.insert(5);

return 0;
}
