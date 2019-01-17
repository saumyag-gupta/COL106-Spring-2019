public class program
{
	public static void main(String args []){
		program obj=new program();
		System.out.println(obj.test(7,0));
	}
	
	public float test(int a, int b)  //Java doesn't throw exception when dividing by float zero.
	{
		/*
		Divide by Zero- Given the two numbers a and b, find the division a/b.
	        The program should handle divide by zero exception.
		*/
		float c;
		try{
		c = a/b;
		}
		catch(ArithmeticException ar){
			System.out.println("Cannot divide by zero");
			return 0;
		}
		return c;
	}
	
}
