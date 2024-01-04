package string;
public class String1 {
	public static void  main(String[] args) {
		int[] nums = {4,5,4,2,42,34,4,234};
		int target = 8;
		System.out.println(twoSum(nums , target));
		
	}
	static int[] twoSum(int[] nums , int target) {
	
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length-1;j++) {
				if((nums[i] + nums[j]) ==target) {
					return new int[]{i,j};
				}
			}
		}
		return null;
	}

}
