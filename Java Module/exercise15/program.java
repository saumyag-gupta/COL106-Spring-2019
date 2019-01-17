public class program
{
	public String test(String hex)
	{
		
		String binary="";
		binary+=convert(hex.charAt(0));
		if(binary.charAt(0)=='0'){
			if(binary.charAt(1)=='0'){
				if(binary.charAt(2)=='0'){
					String x=binary;
					binary="";
					binary+=(x.charAt(3));
				}
				else{		
					String x=binary;
					binary="";
					binary+=(x.charAt(2));
					binary+=(x.charAt(3));
				}
			}
			else{
				String x=binary;
				binary="";
				binary+=(x.charAt(1));
				binary+=(x.charAt(2));
				binary+=(x.charAt(3));
			}
		}
		for(int i=1;i<hex.length();i++){
			binary+=convert(hex.charAt(i));
		}
		//System.out.println(binary);
		return binary;
	}
	
	String convert(char a){
		if(a=='0')
			return "0000";
		if(a=='1')
			return "0001";
		if(a=='2')
			return "0010";
		if(a=='3')
			return "0011";
		if(a=='4')
			return "0100";
		if(a=='5')
			return "0101";
		if(a=='6')
			return "0110";
		if(a=='7')
			return "0111";
		if(a=='8')
			return "1000";
		if(a=='9')
			return "1001";
		if(a=='A')
			return "1010";
		if(a=='B')
			return "1011";
		if(a=='C')
			return "1100";
		if(a=='D')
			return "1101";
		if(a=='E')
			return "1110";
		if(a=='F')
			return "1111";
		
		return "HIHI";
	
	}
}
