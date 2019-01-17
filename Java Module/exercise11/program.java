public class program
{
	public int test(int n, int m)
	{
		/*
		Exercise 11: Least common multiple- Given two integers n and m, the objective
		is to compute the LCM (least common multiple) of n and m. LCM is the smallest
		number that is divisble by both n amd m. For e.g. is n is 12 and m is 14, the
		LCM is 84. If n is 32 and m is 16, the LCM is 32.
		*/
		return n*m/gcd(n,m);
	}
	
	int gcd(int a,int b){
		if(a==0)return b;
		else return gcd(b%a,a);
	}
}
