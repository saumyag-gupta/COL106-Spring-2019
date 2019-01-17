public class program implements Runnable
{
	  public void run(){
		String course [ ] ={ "Java", "C++", "C", "Php"};
		for(int i=0;i<course.length;i++){
		   System.out.println(Thread.currentThread().getName()+" has course "+course[i]);
		   try{
			   Thread.sleep(1000);
			   }
		   catch(InterruptedException e){}
		}
	  }
	  public static void main(String args[]) {
		program obj = new program();
		Thread t1=new Thread(obj);
		Thread t2=new Thread(obj);
		Thread t3=new Thread(obj);
		t1.start();
		t2.start();
		t3.start();
	  }


	
}
