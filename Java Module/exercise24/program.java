import java . util .*;
import java .io .*;

public class program
{
	public static void main(String[] args){
		program obj = new program();
		
		System.out.println(obj.test("file1.txt","file2.txt"));
	}
	public boolean test(String a, String b)
	{
		/*
		File Comparison- Given the names of the two files,compare the contents
		of the files. If the files are same, return true otherwise return false. If there is no
		file with the given name, the program should handle it.
		*/
		int flag=0;
		try {
			FileInputStream file1 = new FileInputStream (a);
			FileInputStream file2 = new FileInputStream (b);
			Scanner s1 = new Scanner ( file1 );
			Scanner s2 = new Scanner ( file2);
			while (s1.hasNextLine() || s2.hasNextLine()){
				String sen1=s1.nextLine();
				String sen2=s2.nextLine();
				//System.out.println(sen1);
				//System.out.println(sen2);
				if(!sen1.equals(sen2)){
					flag=1;
					break;
				}
			}
		} 
		catch ( FileNotFoundException exx) {
			System.out.println(" File not found ");
			return false;
		}
		if(flag==1)
			return false;
		else return true;
	}
	
}
