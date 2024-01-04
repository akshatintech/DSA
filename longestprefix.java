package string;

public class String1 {
	public static void  main(String[] args) {
		String[] str = {"Akshat ", "Akshyy" , "Akshyaa"};
		
		longestprefix(str);
		System.out.println(longestprefix(str));
		
		
	}
	
	
	static String longestprefix(String[] str) {
		if(str.length ==0) return "";
		String prefix = str[0];
		for(int i =1;i<str.length;i++) {
			while(str[i].indexOf(prefix) != 0) {
				prefix=  prefix.substring(0,prefix.length()-1);
			}
		}
	
		return prefix;
	}
}
	

