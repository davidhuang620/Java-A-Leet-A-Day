/*
keys:

array uses arr.length, while String uses str.length()
array uses arr.length == 0, while String uses str.isEmpty()

declare hashmap
HashMap <Integer, Integer> mapVariableName = new HashMap<>();

check if one item in the HashMap, use 
map.containsKey(someKey), instead of !(map.get(someKeys)) (this won't work)


Use arrayList for flexibility, then convert them into array.

ArrayList <Integer> arrVariable = new ArrayList <Integer>();

Arr.add(i);

Arr.get(i);

Arr.set(i, valueToInsert);

Arr.remove(0);

Arr.size();

*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        // valid number check
        
        if(nums1.length == 0 || nums2.length ==0 || nums1 == null || nums2 ==null){
            return new int[0];
        }
        
        ArrayList <Integer> arr = new ArrayList <Integer>();
        HashMap <Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums1.length; i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],1);
            }
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) == 1){
                arr.add(nums2[i]);
                map.put(nums2[i],2);
            }
        }
        
        int [] ans = new int [arr.size()];
        
        for(int i = 0; i < arr.size(); i++){
            ans[i] = arr.get(i);
        }
        
        return ans;
        
    }
}
