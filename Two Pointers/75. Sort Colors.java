// 3 pointers tricky question
// one index that check through each elements
// one left pointer mark where sorted 0 are
// one right pointer mark where sorted 2 are
// Be aware of when to change each pointers 


// One pass
    public void sortColors(int[] nums) {
        
        if (nums == null || nums.length == 0){
            return;
        }
        
        int low = 0, pt = 0, up = nums.length - 1;
        
        while (pt <= up){
            
            if (nums[pt] == 0){
                nums[pt] = nums[low];
                nums[low] = 0;
                low++;
                pt++;
            } else if (nums[pt] == 1){
                pt++;
            } else {
                nums[pt] = nums[up];
                nums[up] = 2;
                up--;
            }
        }
    }

// with swap function
    public void sortColors(int[] nums) {
        
        if (nums == null || nums.length == 0){
            return;
        }
        
        int low = 0, pt = 0, up = nums.length - 1;
        
        while (pt <= up){
            
            if (nums[pt] == 0){
                swap(nums, low, pt);
                low++;
                pt++;
            } else if (nums[pt] == 1){
                pt++;
            } else {
                swap(nums, pt, up);
                up--;
            }
        }
    }
    
    private void swap (int[] nums, int low, int up){
        int temp = nums[low];
        nums[low] = nums[up];
        nums[up] = temp;
    }
    
