/*  

Different than sort, we have k colors.
We can achieve O( N LogK ) if we also do partition on colors, 
which is faster than original quick sort O( N LogN )

careful that we need to use nums[low] <= colMid to put the same color on one side, 
otherwise colors won't be sorted correctly, because the same color could be on both side of the divided array. 
*/

  public void sortColors2(int[] colors, int k) {
        
        if (colors == null || colors.length == 0){
            return;
        }
        
        sort(colors, 0, colors.length - 1, 1, k);
    }
    
    private void sort(int[] nums, int start, int end, int colLow, int colUp){
        
        int low = start, up = end;
        int mid = (start + up) / 2;
        int colMid = (colLow + colUp) / 2;
        
        if (start == end || colLow == colUp){
            return;
        }
        
        while (low <= up){
            while (low <= up && nums[low] <= colMid){
                low++;
            }
            while (low <= up && nums[up] > colMid){
                up--;
            }
            
            if (low <= up){
                int temp = nums[low];
                nums[low] = nums[up];
                nums[up] = temp;
                low++;
                up--;
            }
        }
        
        sort(nums, start, up, colLow, colMid);
        sort(nums, low, end, colMid + 1, colUp);
    }
