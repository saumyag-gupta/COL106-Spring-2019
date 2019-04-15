import java.util.*; 

public class Company{
	Tree tree;
	BST bst;
	
	Company(String CEO){
		this.tree = new Tree(CEO);
		this.bst = new BST(this.tree.root);
	}
	
	Company(){
		this(null);
	}
	
	void AddEmployee(String emp,String boss) throws EmployeeNotFound,EmployeeAlreadyExists{
		Node_Tree Bo = bst.Search(boss);
		Node_Tree Em = tree.Add(emp,Bo);
		bst.Add(Em);
	}
	
	void DeleteEmployee(String oldb,String newb) throws EmployeeNotFound,LevelNotEqualException{
		Node_Tree ob = bst.Delete(oldb);
		Node_Tree nb = bst.Search(newb);
		tree.Delete(ob,nb);
	}
	
	void LowestCommomBoss(String emp1,String emp2) throws EmployeeNotFound{
		Node_Tree ob = bst.Search(emp1);
		Node_Tree nb = bst.Search(emp2);
		System.out.println(tree.LCA(ob,nb));
	}
	
	void PrintEmployee(){
		tree.print_bfs();
	}
}