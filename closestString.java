package string;

public class String1 {
	public static void  main(String[] args) {
		String[] str = {"the", "quick", "brown", "fox", "quick"};
		String word1 ="the";
		String word2 = "fox";
		int answer = distance(str , word1, word2);
		System.out.println(answer);
		
		
	}
	
	static int distance(String[] str , String word1 , String word2) {
		int start =0;
		int end = 0;
		for(int i=0; i<str.length;i++) {
			if(str[i].equals(word1)) {
				start = i;
			}
			if(str[i].equals(word2)) {
				end = i;
			}
		}
		int result = end-start;
		return result;
		
	}
	
	
	
}
	

