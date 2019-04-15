import java.util.*; 

public class BST{
	// Note in this BST, I have not defined any empty leaves. So isLeaf means that the node doesn't have any children 
	// but is still a valid node
	
	Node_BST root;
	
	BST(){
		this(null);
	}
	
	BST(Node_Tree CEO){
		this.root = new Node_BST();
		this.root.element = CEO.name;
		this.root.ptr = CEO;
		this.root.left = null;
		this.root.right =null;
		this.root.Parent = null;
	}
	
	boolean isempty(){
		return (root == null);
	}
	
	void Add (Node_Tree ele) throws EmployeeAlreadyExists{
		Node_BST itr = this.root;
		String val = ele.name;
		
		while(true){
			if(val.compareTo(itr.element)<0 && itr.left == null){
				Node_BST temp = new Node_BST(itr);
				itr.left = temp;
				temp.element = val;
				temp.ptr = ele;
				return;
			}
			else if(val.compareTo(itr.element)>0 && itr.right == null){
				Node_BST temp = new Node_BST(itr);
				itr.right = temp;
				temp.element = val;
				temp.ptr = ele;
				return;
			}
			else if(val.compareTo(itr.element)<0)
				itr = itr.left;
			else if(val.compareTo(itr.element)>0)
				itr = itr.right;
			else{
				// If you find element you wanted to add
				throw new EmployeeAlreadyExists("Employee "+val+" already exists");
			}
		}
	}
	
	Node_Tree Delete(String val) throws EmployeeNotFound{
		Node_BST itr = root;
		
		// If root equals the value to be deleted
		if(val.compareTo(itr.element)==0 ){
			
			Node_Tree ret = root.ptr;
			
			if(root.isLeaf()){
				root = null;
			}
			else if(root.left == null){
				root = root.right; 
			}
			else if(root.right == null){
				root = root.left;
			}
			else{
				Node_BST min = root.right;
				int flag = 0;
				while(min.left != null){
					min = min.left;
					flag = 1;
				}
				
				root.element = min.element;
				root.ptr = min.ptr;
				
				if(min.right == null){
					if(flag == 1){
						min.Parent.left = null;
					}
					else{
						min.Parent.right = null;
					}
				}
				else{
					if(flag == 1){
						min.Parent.left = min.right;
						min.right.Parent = min.Parent;
					}
					else{
						min.Parent.right = min.right;
						min.right.Parent = min.Parent;
					}
				}
			}
			return ret;
		}
		
		while(itr != null){
			//if node to the left of the current node is to be deleted. 
			//This if condition is used so as to make parent pointer manipulation simpler
			if(itr.left != null && val.compareTo(itr.left.element) == 0 ){
				Node_BST tobe = itr.left;
				Node_Tree ret = tobe.ptr;
				if(tobe.isLeaf()){
					itr.left = null;
				}
				else if(tobe.left == null){
					tobe.right.Parent = itr;
					itr.left = tobe.right;
				}
				else if(tobe.right == null){
					tobe.left.Parent = itr;
					itr.left = tobe.left;
				}
				else{
					Node_BST min = tobe.right;
					int flag = 0;
					while(min.left != null){
						min = min.left;
						flag = 1;
					}
					
					tobe.element = min.element;
					tobe.ptr = min.ptr;
					
					if(min.right == null){
						if(flag == 1){
							min.Parent.left = null;
						}
						else{
							min.Parent.right = null;
						}
					}
					else{
						if(flag == 1){
							min.Parent.left = min.right;
							min.right.Parent = min.Parent;
						}
						else{
							min.Parent.right = min.right;
							min.right.Parent = min.Parent;
						}
					}
				}
				return ret;
			}
			//if node to the right of the current node is to be deleted. 
			else if(itr.right != null && val.compareTo(itr.right.element) == 0 ){
				Node_BST tobe = itr.right;
				
				Node_Tree ret = tobe.ptr;
				if(tobe.isLeaf()){
					itr.right = null;
				}
				else if(tobe.left == null){
					tobe.right.Parent = itr;
					itr.right = tobe.right;
				}
				else if(tobe.right == null){
					tobe.left.Parent = itr;
					itr.right = tobe.left;
				}
				else{
					Node_BST min = tobe.right;
					int flag = 0;
					while(min.left != null){
						min = min.left;
						flag = 1;
					}
					
					tobe.element = min.element;
					tobe.ptr = min.ptr;
					
					if(min.right == null){
						if(flag == 1){
							min.Parent.left = null;
						}
						else{
							min.Parent.right = null;
						}
					}
					else{
						if(flag == 1){
							min.Parent.left = min.right;
							min.right.Parent = min.Parent;
						}
						else{
							min.Parent.right = min.right;
							min.right.Parent = min.Parent;
						}
					}
				}
				return ret;
			}
			else{
				if(val.compareTo(itr.element)<0){
					itr = itr.left;
				}
				else{
					itr = itr.right;
				}
			}
		}
		
		//Not found
		throw new EmployeeNotFound("Employee "+val+" was not found");
	}
	
	Node_Tree Search(String val) throws EmployeeNotFound{
		Node_BST itr = root;
		
		while(itr != null){
			if(val.compareTo(itr.element)<0)
				itr = itr.left;
			else if(val.compareTo(itr.element)>0)
				itr = itr.right;
			else{
				return itr.ptr;
			}
		}
		
		//Not Found 
		throw new EmployeeNotFound("Employee "+val+" was not found");
	}
	
	void preorder(){
		print(this.root);
		System.out.println();
	}
	void print(Node_BST it){
		if(it == null)return;
		
		System.out.println(it.element+",");
		print(it.left);
		print(it.right);
	}
	
}