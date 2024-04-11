
/*
A node in a binary tree
*/
class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}
/* 
an entire BST
*/
class BinarySearchTree{
//new info
   Node root;

   
   /*
Inserts a new value to the BST
@param root -root of BST 
@param value - value of the node
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   //begin implementation 
	
   
   /*
   preOrderTraversal Binary tree parse of a bst
   @param root - root node of the BST
   */
   public void preOrderTraversal(Node root){
      //implement me
	   if(root!=null){ 
System.out.print(root.value+" ");  
preOrderTraversal(root.left); //left first then right, lets do this consistently too
preOrderTraversal(root.rigt); //now right 
	   }
   }

   
   
   /*
   in-order traversal of the binary search tree
   @param root - the root node of the BST
   */
   public void inOrderTraversal(Node root){
      //implement me
	   if (root!=null){ 
inOrderTraversal(root.left) //not the end? try again! 
	System.out.println(root.value); 
inOrderTraversal(root.right); 
	   }
   }
   
   
   
   /*
   post-order traversal of the BST
   @param root - root node of the BST
   */
   public void postOrderTraversal(Node root){
      if (root!=null){ 
postOrderTraversal(root.left); 
PostOrderTraversal(root.right); //now check left right -print 
	      System.out.print(root.value); 
      }
   }
   
   
   
   /*
   a method to find the node in the tree with a specific value
   @param root - root node of BST
   @param key - the key value we are looking for
   @return if the key was found in the BST
   */
   public boolean find(Node root, int key){
	   //recursive find if not go left. if not go right
	   if (root == null){ 

	return false; 
	   }
	   if(root.value == key){ 
		   return true; 
	   }
	   if(key<root.value){ 
return find(root.left, key);  
	   }
	   else{
return find(root.right, key);
	   }
      return false;           
   }
   
   
   
   /**
   a method to find the node in the tree with a smallest key
   @param root - the root node of the BST
   @return the int value of the minimum node
   */
   public int getMin(Node root){
      //implement me
	   if (root == null){ 
		   return -1; 
	   }
	   while (root.left !=null){ 
	root=root.left;
	   }
	   return root.value;
   }
  
  
  
   /*
   a method to find the node in the tree with a largest key
   @param root - root node of the bst 
   @return int value of the Maximum value
   */
   public int getMax(Node root){
	  //implement me
	   if (root == null){ 
	return -1;
	   }
	   while (root.right !=null){ 
	   root = root.right
	   }
	   return root.value;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   @param root - root node of the BST 
   @param key - key value to find and delete
   @return the root that is deleted
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}


/** 
A BSt tree with random values
*/
public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}
