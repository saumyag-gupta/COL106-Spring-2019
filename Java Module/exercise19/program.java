public class program
{
	public String test(String s1, String s2, int m, int n)
	{
		
		String ret = s1.substring(m,s1.length());
		ret+=s2.substring(0,n+1);
		return ret;
	}
}
