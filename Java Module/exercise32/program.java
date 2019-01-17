public class program 
{
	public static void main(String args[]){
		Xcord a1= new Xcord(5);
		Ycord b1= new Ycord(2);
		Zcord c1= new Zcord(3);
		a1.start();
		b1.start();
		c1.start();
		try{   // wait for completion of all thread and then sum
			a1.join();
			b1.join(); 
			c1.join();
			double r =a1.sqx+b1.sqy+c1.sqz;
			System.out.println("Radius square of circle with center at origin is "+r);
		} 
		catch(InterruptedException IntExp) {}
	 }

	
	static class Zcord extends Thread
	{
		double z,sqz;
		public Zcord(double Zval){
		 z=Zval;
		}
		public void run(){
			System.out.println("Calculating square of "+z);
			sqz=z*z;
			System.out.println("Calculated square of "+sqz);
		}
		
	}
	
	static class Xcord extends Thread {
		double x,sqx;
		public Xcord(double xval){
		 x=xval;
		}
		public void run(){
			System.out.println("Calculating square of "+x);
			sqx=x*x;
			System.out.println("Calculated square of "+sqx);
		}
	}

	static class Ycord extends Thread {
		double y,sqy;
		public Ycord(double yval){
		 y=yval;
		}
		public void run(){
			System.out.println("Calculating square of "+y);
			sqy=y*y;
			System.out.println("Calculated square of "+sqy);
		}
	}
}
