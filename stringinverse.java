package string;

public class String1 {
	public static void  main(String[] args) {
		String str = "Akshat";
		inverse(str);
		
		
	}
	static void inverse(String str) {
		for(int i=str.length()-1 ;i>=0;i--) {
			System.out.print(str.charAt(i));
		}
		
	}


}

