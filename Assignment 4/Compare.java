import java.util.*; 
import java.io.*;

public class compare{
	public static void main(String args[]){
		try{
		File file1 = new File("large_ans.txt"); 
		File file2 = new File("output.txt"); 
		
		PrintStream fileOut = new PrintStream("./difference.txt");
		System.setOut(fileOut);
			
		Scanner input1 = new Scanner(file1);
		Scanner input2 = new Scanner(file2);
		
		int diff=0,lines=0;
		while(input1.hasNext() && input2.hasNext()){
			lines++;
			String s1 = input1.next();
			String s2 = input2.next();
			
			if(!(s1.equals(s2))){
				diff++;
				System.out.println("Difference on line "+lines);
			}
			
		}
		int line = lines;
		if(input1.hasNext()){
			System.out.println("Input 2 ends on line "+lines);
			while(input1.hasNext()){
				String s1 = input1.next();
				line++;
			}
		}
		else if(input2.hasNext()){
			System.out.println("Input 1 ends on line "+lines);
			while(input2.hasNext()){
				String s1 = input2.next();
				line++;
			}
		}
		System.out.println();
		System.out.println("The total number of differences = "+diff);
		System.out.println("The total number of lines in smaller file = "+lines);
		System.out.println("The total number of lines in larger file = "+line);
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}
	}
}