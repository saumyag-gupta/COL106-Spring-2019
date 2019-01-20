
public class checker{
	public static void main(String [] args){
		
		int[] arr = new int[]{ 2,2,3 };
		GeneralizedTowerOfHanoi.gtoh_without_recursion(3,1,arr);
		System.out.println();
		GeneralizedTowerOfHanoi.gtoh_with_recursion(3,1,arr);
		
		/*TowerOfHanoi.toh_without_recursion(4,1,1);
		System.out.println();
		TowerOfHanoi.toh_with_recursion(3,1,3);
		*/
		
		/*MyStack<Integer> test = new MyStack();
		test.push(1);
		test.push(2);
		System.out.println(test.pop());
		test.push(3);
		test.display();
		*/
	}
}