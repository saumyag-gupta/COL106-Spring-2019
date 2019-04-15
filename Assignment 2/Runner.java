import java.util.*; 
import java.io.*;

public class Runner{
	public static void main(String args[]){
		long startTime = System.nanoTime();
		try{
			
			//File file = new File(args[0]); 
			File file = new File("test_case1.txt"); 
			
			PrintStream fileOut = new PrintStream("./output.txt");
			System.setOut(fileOut);
			
			Scanner input = new Scanner(file);
			
			int n = input.nextInt();
			
			String CEO,emp1,emp2;
			
			emp1 = input.next();
			CEO = input.next();
			
			n-=2;
			Company IITD = new Company(CEO);
			
			IITD.AddEmployee(emp1,CEO);
			
			while(n!=0){
				n--;
				emp1 = input.next();
				emp2 = input.next();
				IITD.AddEmployee(emp1,emp2);
			}
			n = input.nextInt();
			
			while(n!=0){
				n--;
				int choice = input.nextInt();
				
				if(choice == 0){
					emp1 = input.next();
					emp2 = input.next();
					IITD.AddEmployee(emp1,emp2);
				}
				else if(choice == 1){
					emp1 = input.next();
					emp2 = input.next();
					IITD.DeleteEmployee(emp1,emp2);
				}
				else if(choice == 2){
					emp1 = input.next();
					emp2 = input.next();
					IITD.LowestCommomBoss(emp1,emp2);
				}
				else if(choice == 3){
					IITD.PrintEmployee();
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}catch(EmployeeAlreadyExists e){
			System.out.println(e);
		}catch(EmployeeNotFound e){
			System.out.println(e);
		}catch(LevelNotEqualException e){
			System.out.println(e);
		}
		
		long endTime = System.nanoTime();
		
		//System.out.println("Took "+(endTime-startTime)+" ns");
	}
}