import java.util.*; 

public class Tree{
	
	Node_Tree root;
	
	Tree(){
		this(null);
	}
	
	Tree(String CEO){
		this.root = new Node_Tree();
		this.root.name = CEO;
		this.root.level = 1;
		this.root.Parent = null;
	}
	
	boolean isempty(){
		return (root == null);
	}
	
	Node_Tree Add(String val,Node_Tree parent){
		Node_Tree ele = new Node_Tree(parent);
		parent.Children.add(ele);
		ele.level = parent.level + 1;
		ele.name = val;
		return ele;
	}
	// We throw exception if the levels are not same 
	void Delete (Node_Tree val1,Node_Tree val2) throws LevelNotEqualException{
		if(val1.level != val2.level){
			throw new LevelNotEqualException("Employees "+val1.name+" & "+val2.name+" don't have the same level");
		}
		val1.Children.forEach((n) -> Tree.transfer(n,val2));
		val1.Parent.Children.remove(val1);
	}
	
	static void transfer(Node_Tree n,Node_Tree val2){
		val2.add_child(n);
		n.Parent = val2;
	}
	
	String LCA(Node_Tree val1,Node_Tree val2){
		Node_Tree high,low;
		if(val1.level < val2.level){
			high = val1;
			low = val2;
		}
		else{
			high = val2;
			low = val1;
		}
		
		while(low.level != high.level){
			low = low.Parent;
		}
		if(low == high){
			low = low.Parent;
			return low.name;
		}
		
		while(low != high){
			low = low.Parent;
			high = high.Parent;
		}
		
		return low.name;
	}
	
	void print_bfs(){
		Queue<Node_Tree> q = new LinkedList<>();
		q.add(this.root);
		int lvl = 1;
		while(q.size() !=0 ){
			Node_Tree itr = q.remove();
			itr.Children.forEach((n) -> q.add(n)); 
			
			/*if(itr.level > lvl){
				lvl=itr.level;
				System.out.println();
			}*/
			System.out.println(itr.name);
		}
	}
}