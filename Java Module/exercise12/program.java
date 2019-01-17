import java.lang.Math;

public class program
{
	public float[] test(int b, int c)
	{
		/*
		Exercise 12: Roots of polynomial- Write a Java program that given b and c,
		computes the roots of the polynomial x*x+b*x+c. You can assume that the
		roots are real valued and need to be return in an array.
		Return the result in an array [p,q] where p<=q meaning the smaller 
		element should be the first element of the array
		*/
		float d1,d2;
		float D=b*b-4*c;
		d1=(float)(-b+Math.sqrt(D));d1/=2;
		d2=(float)(-b-Math.sqrt(D));d2/=2;
		
		float ret[] = {d2,d1};
		return ret;
	}
}
