import java.util.*;

public class caller{
	public static void main(String [] args){
		
		/*int[] arr = new int[]{ 2,2,3 };*/
		/*GeneralizedTowerOfHanoi.gtoh_with_recursion(8,1,2,3);*/
		GeneralizedTowerOfHanoi.gtoh_without_recursion(7,2,2,1);
		System.out.println();
		//GeneralizedTowerOfHanoi.gtoh_with_recursion(6,1,2,3);
		
		/*TowerOfHanoi.toh_without_recursion(4,1,1);
		System.out.println();
		TowerOfHanoi.toh_with_recursion(3,1,3);
		*/
		TowerOfHanoi.toh_with_recursion(6,1,1);
		/*MyStack<Integer> test = new MyStack();
		test.push(1);
		test.push(2);
		System.out.println(test.pop());
		//test.push(3);
		test.display();
		try{
			System.out.println(test.pop());
			System.out.println(test.pop());
		}catch(EmptyStackException e){
			System.out.println("No element in Stack to delete");
		}*/
	}
}