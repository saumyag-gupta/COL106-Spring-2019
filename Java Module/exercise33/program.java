public class program implements Runnable
{
	public synchronized void count(int i) { 
		System.out.println(Thread . currentThread (). getName ()+" prints "+i);
	}
	
	public void run () {
		int i;
		if(Thread.currentThread().getName().equals("Thread-0")){
			i=1;
			while(i<=10){
				count(i);
				i+=2;
				try{
					   Thread.sleep(1000);
					   }
				   catch(InterruptedException e){}
			}
			
		}
		else{
			i=2;
			while(i<=10){
				count(i);
				i+=2;
				try{
					   Thread.sleep(1000);
					   }
				   catch(InterruptedException e){}
			}
		}
	} 
	
	public static void main(String args[]){
		program obj = new program();
		Thread odd = new Thread(obj);
		Thread even = new Thread(obj);
		odd.start();
		even.start();
	}
	
}
