import java.util.*; 

class Node_BST{
	String element;
	Node_BST Parent;
	Node_BST left;
	Node_BST right;
	Node_Tree ptr;
	
	Node_BST(){
		this(null);
	}
	
	Node_BST(Node_BST Papa){
		this.Parent = Papa;
		this.left = null;
		this.right = null;
		this.ptr = null;
	}
	
	boolean isLeaf(){
		return ((left == null)&&(right == null));
	}

}

class Node_Tree{
	String name;
	Node_Tree Parent;
	int level;
	ArrayList<Node_Tree> Children;
	
	Node_Tree(){
		this.Parent = null;
		this.name = null;
		this.Children = new ArrayList<Node_Tree>();
	}
	
	Node_Tree(Node_Tree Papa){
		this.Parent = Papa;
		this.Children = new ArrayList<Node_Tree>();
	}
	
	void add_child(Node_Tree Beta){
		this.Children.add(Beta);
	}
}

class EmployeeNotFound extends Exception{
   String str;
 
   EmployeeNotFound(String error_message) {
	this.str=error_message;
   }
   public String toString(){ 
	return str ;
   }
}

class EmployeeAlreadyExists extends Exception{
   String str;
 
   EmployeeAlreadyExists(String error_message) {
	this.str=error_message;
   }
   public String toString(){ 
	return str ;
   }
}

class LevelNotEqualException extends Exception{
   String str;
 
   LevelNotEqualException(String error_message) {
	this.str=error_message;
   }
   public String toString(){ 
	return str ;
   }
}