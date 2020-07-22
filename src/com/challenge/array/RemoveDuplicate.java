package com.challenge.array;

public class RemoveDuplicate {
	
	public static void main(String[] args) {
		RemoveDuplicate r = new RemoveDuplicate();
		int nums[] = {1,1,1,1,2,2,3};
		r.removeDuplicates(nums);
	}
	
	/*public int removeDuplicates(int[] nums) {
        
        if(nums.length==0)
            return 0;
        
        int sP = 0;
        int fP = 0;
        
        int count = 0;
        int prev = Integer.MIN_VALUE;
        while(fP<nums.length){
            if(nums[fP] == prev){
                count++;
                if(count<=2) {
                	nums[sP] = nums[fP];
                    sP++;
                }
            } else {
                prev = nums[fP];
                nums[sP] = nums[fP];
                count = 1;
                sP++;
            }
            fP++;
            
        }
        nums[sP-1] = nums[fP-1];
        
        return sP;
        
    }*/
	
	public int removeDuplicates(int[] nums) {
		
		int j=1, count =1;
		
		for(int i =1;i< nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				count ++;
			} else {
				count = 1;
			}
			
			if(count <= 2) {
				nums[j++] = nums[i];
			}
		}
		
		return j;
		
	}

}
