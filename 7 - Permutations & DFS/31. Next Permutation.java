/*
从末尾往左走，如果一直递增，例如...9,7,5，那么下一个排列一定会牵扯到左边更多的数，直到一个非递增数为止，例如...6,9,7,5。
对于原数组的变化就只到6这里，和左侧其他数再无关系。6这个位置会变成6右侧所有数中比6大的最小的数，而6会进入最后3个数中，且后3个数必是升序数组。

所以算法步骤如下：

从右往左遍历数组nums，直到找到一个位置i，满足nums[i] > nums[i - 1]或者i为0。
i不为0时，用j再次从右到左遍历nums，寻找第一个nums[j] > nums[i - 1]。
而后交换nums[j]和nums[i - 1]。注意，满足要求的j一定存在！且交换后nums[i]及右侧数组仍为降序数组。
将nums[i]及右侧的数组翻转，使其升序。

*/

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        
        int toMove = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--){
            if (i == 0){
                reverse(nums, 0, nums.length - 1);
                return;
            }
            if (nums[i] > nums[i - 1]){
                toMove = i -1;
                break;
            }
        }
        
        for (int j = nums.length - 1; j >= 0; j--){
            if (nums[j] > nums[toMove]){
                swap(nums, j, toMove);
                break;
            }
        }
        reverse(nums, toMove + 1, nums.length - 1);
        
    }
    
    private void swap(int[] nums, int low, int up){
        int temp = nums[low];
        nums[low] = nums[up];
        nums[up] = temp;
    }
    
    private void reverse(int[] nums, int low, int up){
        while (low < up){
            swap(nums, low, up);
            low ++;
            up --;
        }
    }
    
}
