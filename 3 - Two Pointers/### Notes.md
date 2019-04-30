## 2 Sum

**Hashtable:**  
Time complexity = O(N)
Space complexity = O(N)

**Two pointers:**  
Time complexity = O(N) (if sorted, faster than hashtable method)    
Time complexity = O(nlogn) (if not sorted)  
Space complexity = O(1)

```Java
int[] ans = new int[2];
        int i = 0, j = nums.length - 1;
        while (i < j){
            if (nums[i] + nums[j] == target){
                ans[0] = i + 1;
                ans[1] = j + 1;
                return ans;
            }
            if (nums[i] + nums[j] > target){
                j--;
            }
            if (nums[i] + nums[j] < target){
                i++;
            }
        }
        
        return ans;

```

## Duplicates Problem  

How do we dedupe if an array ?  
1. we need to make it sorted  
2. we select the first occurance of the element  

```Java
Arrays.sort(nums);
int unique = 0;
for (int i = 0; i < nums.length; i++){
    if (i > 0 && nums[i] == nums[i-1]){
         continue;
    }
    nums[unique++] = nums[i];
}
return unique;
```
(https://www.lintcode.com/problem/remove-duplicate-numbers-in-array/description)  

This line is very important, it could be use in a lot other cases  
This make sure that we still take the first occurance, but ignore all other duplicates comes after
```Java
if (i > 0 && nums[i] == nums[i - 1])
```

### 2 Sum - duplicates

dedupe in the target found condition
since we are deduping for the target found

```Java
                // dedupe for low
                while (low < up && nums[low] == nums[low - 1]){
                    low++;
                }
                // dedupe for up
                while(low < up && nums[up] == nums[up + 1]){
                    up--;
                }   
```

(https://www.lintcode.com/problem/two-sum-unique-pairs/description)

```Java
        Arrays.sort(nums);
        int low = 0, up = nums.length - 1;
        int count = 0;
        while(low < up){
            if (low < up && nums[low] + nums[up] == target){
                count++;
                low++;
                up--;
                // dedupe in the target found condition
                // since we are deduping for the target found
                // Also, we already low ++, up-- 
                // so the boundary cases are already got taken care of (low > 0, up + 1 < nums.length)
                
                // dedupe for low
                while (low < up && nums[low] == nums[low - 1]){
                    low++;
                }
                // dedupe for up
                while(low < up && nums[up] == nums[up + 1]){
                    up--;
                }   
            } else if (low < up && nums[low] + nums[up] < target){
                low++;
            } else {
                up--;
            }
        }

```

### 3 Sum with duplicates   

(https://leetcode.com/problems/3sum/)  

3 Sum duplicates is even more tricky  
1. Sort the Array  
2. At the for loop, dedupe for the first element for the triple  
3. At the twoSum function, dedupe for the second element, and third element of the triple  (Same as two sum)  

```Java
    public List<List<Integer>> threeSum(int[] numbers) {
        if (numbers == null || numbers.length == 0){
            return new ArrayList<>();
        }
        
        // Sort!! 
        Arrays.sort(numbers);
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++){
            // dedupe the first elements in the triple 
            if (i > 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            // find the 2, 3 elements in the triple
            twoSum(numbers, -numbers[i], i + 1, ans);
        }
        return ans;
    }
    
    private void twoSum(int[] nums, int target, int start, List<List<Integer>> ans){
        
        int low = start, up = nums.length - 1;
        while (low < up){
            
            if (nums[low] + nums[up] == target){
                List<Integer> triple = new ArrayList<>();
                triple.add(nums[start - 1]);
                triple.add(nums[low]);
                triple.add(nums[up]);
                ans.add(triple);
                low++;
                up--;
                // put it in the target found condition
                // Because we are deduping for the correct ans 
                // Deduping for the pair 
                while(low < up && nums[low] == nums[low - 1]){
                    low++;
                }
                while(low < up && nums[up] == nums[up + 1]){
                    up--;
                }
            } else if (nums[low] + nums[up] < target){
                low++;
            } else {
                up--;
            }
        }
    }
```
