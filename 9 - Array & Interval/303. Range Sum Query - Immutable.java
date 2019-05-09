class NumArray {

    int[] sumArr;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }        
        
        sumArr = new int[nums.length + 1];
        sumArr[0] = 0;
        for (int i = 0; i < nums.length; i++){
            sumArr[i + 1] = sumArr[i] + nums[i];
        }
        
    }
    
    public int sumRange(int i, int j) {
        return sumArr[j + 1] - sumArr[i];
    }
}
