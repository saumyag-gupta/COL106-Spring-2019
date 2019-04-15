import java.io.*;
import java.util.*; 
import java.lang.*;

public class compress{
	
	public static void main(String[] args){
		long startTime = System.nanoTime();
		try{
			String in_file = args[0];
			String out_file = args[1];
			
			OutputStream os = new FileOutputStream(out_file);
			//System.out.println(out_file);
			int DictSize = 0,maxSize = (int)Math.pow(2,16);

			Dict Dict_obj = new Dict();
			
			for (int i = 0; i < 128; i++)
			{
				Dict_obj.put("" + (char)i, i);
				DictSize++;
			}
			
			String rawtext = new Scanner(new File(in_file)).useDelimiter("\\A").next();
			//System.out.print(rawtext);
			String p = "";
			
			for (char c : rawtext.toCharArray()) {
				String pc = p + c;
				if (Dict_obj.containsKey(pc))
					p = pc;
				else {
					
					int toadd = Dict_obj.get(p);
					os.write(toadd/256);
					os.write(toadd%256);
					p = "" + c;
					if(DictSize < maxSize)
						Dict_obj.put(pc,DictSize++);
		
				}
			}
	 
			if (!p.equals("")){
				int toadd = Dict_obj.get(p);
				os.write(toadd/256);
				os.write(toadd%256);
			}
		
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		long endTime = System.nanoTime();
		System.out.println("Took "+((float)(endTime-startTime)/1000000000)+" s");
	}
}