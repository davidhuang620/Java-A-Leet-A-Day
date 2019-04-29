
## Binary Search

```Java

    public int BinarySearch(int[] nums, int target) {
        
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        int left = 0, right = nums.length-1;
        
        // KEY 1: left + 1 < right  
        // We exit the while loop with exactly two indexes 
        while( left + 1 < right ){
          
            // KEY 2: left + (right - left) / 2 
            // To avoid max Integer overflow
            int mid = left + (right - left) / 2;
            
            // KEY 3: 3 cases
            // This could be further optimized with mid-1 or mid +1, 
            // but we wanna keep it clean (save brain power)
            if( nums[mid] == target){
                return mid; // we wanna change this if we are finding first or last element
            }
            if( nums[mid] < target){
                left = mid;
            }
            if( nums[mid] > target){
                right = mid;
            }
            
        }
        
        // KEY 4: check for left index and right index, the ORDER MATTERS
        // Depends on whether we are looking for first element or last element
        // Since we exit the while loop with exactly two indexes, we need to check both
        
        if (nums[left] == target){
            return left;
        }
        if (nums[right] == target){
            return right;   
        }
        
        return -1;
    }

```

