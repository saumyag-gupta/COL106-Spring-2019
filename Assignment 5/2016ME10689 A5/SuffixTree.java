import java.util.*;
import java.io.*;

public class SuffixTree{
	
	String text;
	Node root;
	
	SuffixTree(String text){
		this.text = text+'$';
		root = new Node();
		for(int i=0;i<text.length();i++){
			this.insert(i);
		}
	}
	
	void insert(int i){
		Node curr = root;
		int curr_suffix = i;
		int j=0;
		int n = this.text.length();
		
		for(;i<n;){
			if(j<curr.size()){
				if(text.charAt(i) == text.charAt(curr.s+j)){
					i++;j++;
				}else{
					int index1 = (int)(text.charAt(i));
					int index2 = (int)(text.charAt(curr.s+j));
					int index3 = (int)(text.charAt(curr.s));
					
					Node dada = curr.papa;
					Node temp = new Node();
					temp.papa = dada;
					curr.papa = temp;
					temp.bacche[index2] = curr;
					dada.bacche[index3] = temp;
					temp.s = curr.s;
					temp.e = curr.s+j-1;
					curr.s = curr.s+j;
					
					temp.bacche[index1] = new Node();
					temp.bacche[index1].papa = temp;
					temp.bacche[index1].s = i;
					temp.bacche[index1].e = n-1;
					temp.bacche[index1].isleaf = true;
					temp.bacche[index1].suffix = curr_suffix;
					break;
					
				}
			}
			else{
				int index = (int)(text.charAt(i));	
				
				if(curr.bacche[index] == null){
					curr.bacche[index] = new Node();
					curr.bacche[index].papa = curr;
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
	
	void search(String pat,Node start,AVL<Integer> sort){
		Node curr = start;
		int j=0,flag=0;
		
		for(int i=0;i<pat.length();){
			if(j<curr.size()){
				
				if(pat.charAt(i) == text.charAt(curr.s+j) || pat.charAt(i) == '?'){
					i++;j++;
				}else{
					flag = 1;
					break;
				}
			}
			else{
				if(pat.charAt(i) == '?'){
					String subpat = pat.substring(i);
					for(int kk = 0;kk<128;kk++){
						if(curr.bacche[kk] != null)
							search(subpat,curr.bacche[kk],sort);
					}
					flag = 1;
					break;
				}
				else{
					int index = (int)(pat.charAt(i));	
					
					if(curr.bacche[index] == null){
						flag = 1;
						break;
					}else{
						j=0;
						curr = curr.bacche[index];
					}
				}
			}
		}
		
		if(flag != 1){
			Queue<Node> q =new LinkedList<Node>(); 
			q.add(curr);
			while(!q.isEmpty()){
				Node front = q.remove();				
				if(front.isleaf == true){
					sort.insert(front.suffix);
				}
				else{
					for(int kk=0;kk<128;kk++){
						if(front.bacche[kk] != null)
							q.add(front.bacche[kk]);
					}
				}
			}
		}
		
	}
	
	void print(){
		Queue<Node> q =new LinkedList<Node>(); 
		q.add(this.root);
			
		while(!q.isEmpty()){
			Node front = q.remove();
			if(front.s !=-1)
				System.out.println(text.substring(front.s,front.e+1));
			
				if(front.isleaf == true){
					
				}
				else{
					for(int kk=0;kk<128;kk++){
						if(front.bacche[kk] != null)
							q.add(front.bacche[kk]);
					}
				}
		}
	}
	
	public static void main(String args[]){
		String inputfileName = args[0];
		String outputfileName = args[1];
		String txt="";
		long startTime = System.nanoTime();
		try{
			
			File file = new File(inputfileName); 
			//File file = new File("new_large.txt"); 
			
			PrintStream fileOut = new PrintStream(outputfileName);
			//PrintStream fileOut = new PrintStream("./output.txt");
			System.setOut(fileOut);
			
			Scanner input = new Scanner(file);
			
			txt = input.nextLine();
			int n = txt.length();
			SuffixTree iitd = new SuffixTree(txt);
			//iitd.print();
			int tt = input.nextInt();
			input.nextLine();
			for(int zzz = 0;zzz<tt;zzz++){
				String pattern = input.nextLine();
				int fl = -1;
				for(int itr = 0;itr<pattern.length();itr++){
					if(pattern.charAt(itr) == '*')
						fl =itr;
				}
				
				if(fl == -1){
					Integer len = new Integer(pattern.length());
					AVL<Integer> ans = new AVL<>();
					LinkedList<Integer> sorted =new LinkedList<Integer>(); 
					
					if(len>0)
					iitd.search(pattern,iitd.root,ans);
					
					ans.get_list(sorted);
					
					while(!sorted.isEmpty()){
						Integer aa = sorted.remove();
						Integer bb = aa + len-1;
						if(bb<n)
							System.out.println(aa+" "+bb);
					}
				}
				else{
					int fla=0;
					String subpat1 = pattern.substring(0,fl);
					String subpat2 = pattern.substring(fl+1);
					int len1 = subpat1.length();
					int len2 = subpat2.length();
					AVL<Integer> ans1 = new AVL<>();
					AVL<Integer> ans2 = new AVL<>();
					
					LinkedList<Integer> sorted1 = new LinkedList<Integer>(); 
					LinkedList<Integer> sorted2 = new LinkedList<Integer>(); 
					
					if(len1>0){
						iitd.search(subpat1,iitd.root,ans1);
						ans1.get_list(sorted1);
					}
					else{fla=1;
						for(int i=0;i<n;i++)
							sorted1.add(i);
					}
					if(len2>0){
						iitd.search(subpat2,iitd.root,ans2);
						ans2.get_list(sorted2); 
					}
					else{fla=1;
						for(int i=0;i<n;i++)
							sorted2.add(i);
					}
					
					while(!sorted1.isEmpty()){
						Integer a1 = sorted1.remove();
						Integer b1;
						if(len1>0)
							b1 = a1 + len1 -1;
						else b1 = a1;
						
						ListIterator<Integer> list_Iter = sorted2.listIterator();
						while(list_Iter.hasNext()){ 
							Integer x1 = list_Iter.next(); 
							Integer y1;
							if(len2>0)
								y1 = x1 + len2 -1;
							else y1=x1;
							if((b1.compareTo(x1)<0 && fla==0) || (b1.compareTo(x1)<=0 && fla==1)){
								System.out.println(a1+" "+y1);
							}
						} 
					}
				}
				//System.out.println(pattern);
			}
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}
		
		long endTime = System.nanoTime();
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		System.out.println("Took "+((float)(endTime-startTime)/1000000000)+" s");
		//System.out.println(txt);
	}
}