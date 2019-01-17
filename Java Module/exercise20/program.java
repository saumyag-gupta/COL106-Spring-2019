public class program
{
	public int test(char key[], char answer[])
	{
		
		int ret = 0,i=0;
		for(char k:key){
			if(answer[i]==k){
				ret+=4;
			}
			else if(answer[i]!='?'){
				ret-=1;
			}
			i++;
		}
		return ret;
	}
}
