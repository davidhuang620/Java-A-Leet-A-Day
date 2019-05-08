/*

There's another faster solution that transform the whole string into a int array
the int array has the count on 26 letters, then transform the array into a string
then create a hashmap that stores the string as the key
It will take O(n * K) time
where n is the total string, K is the string length 

The following takes O(n * klogk) time

*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0){
            return ans;
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String str : strs){
            
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String newStr = String.valueOf(strArr);
            
            if (!map.containsKey(newStr)){
                map.put(newStr, ans.size());
                ans.add(new ArrayList<>()); 
            }
            
            List<String> strList = ans.get(map.get(newStr));
            strList.add(str);
        }
        
        return ans;
    }
}
