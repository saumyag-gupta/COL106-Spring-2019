import java.util.*; 

public class program
{
	public String[] test(String fileNames[])
	{
		
		String javaFiles[];
		ArrayList<String> list=new ArrayList<String>();
		
		for(int i=0;i<fileNames.length;i++){
			//System.out.println(fileNames[i].substring(fileNames[i].length()-5,fileNames[i].length()));
			String sub=fileNames[i].substring(fileNames[i].length()-5,fileNames[i].length());
			if(sub.equals(".java")){
				list.add(fileNames[i]);
			}
		}
		javaFiles=new String[list.size()]; int i=0;
		//System.out.println(list);
		for(String obj:list) { 
			javaFiles[i]=obj;i++;
		 }  
		return javaFiles;
	}
}
