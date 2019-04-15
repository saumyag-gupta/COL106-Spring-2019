import java.util.*;
import java.io.*;

public class SuffixTree{
	
	String text;
	Node root;
	
	SuffixTree(String text){
		this.text = text+'$';
		root = new Node();
		for(int i=0;i<this.text.length();i++){
			this.insert(i);
		}
	}
	
	void insert(int i){
		Node curr = root;
		int curr_suffix = i;
		int j=0;
		int n = this.text.length();
		
		for(;i<n;i++){
			if(j<curr.size()){
				if(text.charAt(i) == text.charAt(curr.s+j)){
					i++;j++;
				}else{
					int index1 = (int)(text.charAt(i));
					int index2 = (int)(text.charAt(curr.s+j));
					
					Node temp = new Node();
					temp.papa = curr.papa;
					curr.papa = temp;
					temp.bacche[index2] = curr;
					temp.e = curr.s+j-1;
					curr.s = curr.s+j;
					
					temp.bacche[index1] = new Node();
					temp.bacche[index1].s = i;
					temp.bacche[index1].e = n-1;
					temp.isleaf = true;
					temp.suffix = curr_suffix;
					break;
					
				}
			}
			else{
				int index = (int)(text.charAt(i));	
				
				if(curr.bacche[index] == null){
					curr.bacche[index] = new Node();
					curr = curr.bacche[index];
					curr.s = i;
					curr.e = n-1;
					curr.isleaf = true;
					curr.suffix = curr_suffix;
					break;
				}else{
					j=0;
					curr = curr.bacche[index];
				}
			}
		}
	}
	
	void search(String pat){
		
	}
	
	public static void main(String args[]){
		String inputfileName = args[0];
		String outputfileName = args[1];
		
		long startTime = System.nanoTime();
		try{
			
			File file = new File(inputfileName); 
			//File file = new File("new_large.txt"); 
			
			PrintStream fileOut = new PrintStream(outputfileName);
			//PrintStream fileOut = new PrintStream("./output.txt");
			System.setOut(fileOut);
			
			Scanner input = new Scanner(file);
			
			String txt = input.next();
			SuffixTree iitd = new SuffixTree(txt);
			
			int tt = input.nextInt();
			
			for(int zzz = 0;zzz<tt;zzz++){
				String pattern = input.next();
				iitd.search(pattern);
			}
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}
		
		long endTime = System.nanoTime();
		System.out.println("Took "+((float)(endTime-startTime)/1000000000)+" s");
	}
}