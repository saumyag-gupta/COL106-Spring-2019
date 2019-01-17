class Branch{
	public int sup;
	public void getBranch(){
		System.out.println("I am in IIT");
		sup=2;
	}
}

class ComputerScience extends Branch{
	public int sub1;
	public void getBranch(){
		System.out.println("I am in Computer Science");
		sup=3;
		sub1=3;
	}
}

class Electrical extends Branch{
	public int sub2;
	public void getBranch(){
		System.out.println("I am in Electrical");
		sup=4;
		sub2=4;
	}
}

public class program
{
	/*Create a class ’Branch’ having a method ’getBranch’ that prints "I
	am in IIT". It has two subclasses namely ’ComputerScience’ and ’Electrical’ each
	having a method with the same name that prints "I am in Computer Science" and
	"I am in Electrical" respectively. Call the method by creating an object of each of
	the three classes.*/
	
	public static void main(String[] args){
		Branch ob1=new Branch();
		Branch ob2=new ComputerScience();
		Branch ob3=new Electrical();
		
		ob1.getBranch();
		ob2.getBranch();
		ob3.getBranch();
		//System.out.println(ob3.sub2);
	}
	
}
