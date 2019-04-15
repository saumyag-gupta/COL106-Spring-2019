import java.io.*;
import java.util.*; 
import java.lang.*;

public class decompress{
	private static int buftoint(byte[] buffer){
		int sum=0;
		for(byte i:buffer){
			sum*=256;
			if(i>=0)
				sum+=i;
			else{
				sum+=(256+i);
			}
		}
		
		//System.out.println(sum);
		return sum;
	}
	
	public static void main(String[] args){
		long startTime = System.nanoTime();
		try{
			String in_file = args[0];
			String out_file = args[1];
			
			InputStream is = new FileInputStream(in_file);
			
			PrintStream fileOut = new PrintStream(out_file);
			System.setOut(fileOut);
			
			int BUFFER_SIZE = 2;
			int DictSize = 0,maxSize = (int)Math.pow(2,16);
			String[] rev_dict = new String[maxSize];
			
			for (int i = 0; i < 128; i++){
				rev_dict[i]=""+(char)i;
				DictSize++;
			}
			
			byte[] buffer = new byte[BUFFER_SIZE];
			is.read(buffer);
			int k=0;
			k = decompress.buftoint(buffer);
			
			String p = "" + (char)k;
			System.out.print(p);
			
			while (is.read(buffer) != -1) {
				
				String toadd;
				
				k = decompress.buftoint(buffer);
				if (rev_dict[k] != null)
					toadd = rev_dict[k];
				else if (k == DictSize)
					toadd = p + p.charAt(0);
				else {
					return;       //error, wrong compressing has been done
				}
				
				System.out.print(toadd);
	 
				if(DictSize<maxSize)
					rev_dict[DictSize++] = p + toadd.charAt(0);
	 
				p = toadd;
			}
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		long endTime = System.nanoTime();
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		System.out.println("Took "+((float)(endTime-startTime)/1000000000)+" s");
	}
}