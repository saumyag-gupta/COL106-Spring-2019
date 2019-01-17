class shape{
	public float area(int rad){
		return 3.1415f*rad*rad;
	}
	
	public float area(int a,int b){
		return a*b;
	}
}

public class program
{
	/*Area- Create a class to calculate and print the area of a square and a
	rectangle. The class will have two methods with the same name but different number
	of parameters. The method for printing area of rectangle has two parameters which
	are length and breadth respetively while the other method for printing area of square
	has one parameter which is side of square.*/
		public static void main(String[] args){
			shape obj=new shape();
			System.out.println("Area of rectangle is "+Float.toString(obj.area(2,3)));
			System.out.println("Area of circle is "+Float.toString(obj.area(2)));
		}
	
}
