    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }

        for (int pt1 = 0, pt2 = 0; pt2 < nums.length; pt2++){
            if (nums[pt2] != 0){
                int temp = nums[pt1];
                nums[pt1] = nums[pt2];
                nums[pt2] = temp;
                pt1++;
            }
        }
                
    }
