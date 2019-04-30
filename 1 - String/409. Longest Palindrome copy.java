/* 

In characters/String problems, since alphabet is a constant number,
we can use arr of size 256 instead of a regular hash map.

It saved a lot of time and codes! 

One single line of this: 

             for(int i = 0; i < s.length(); i++){
                        arr[s.charAt(i)]++;
             }

REPLACE this whole code block: 

            // if( ! map.containsKey(s.charAt(i))){
            //     map.put(s.charAt(i), 1);
            //     singleChar++;
            // } else{
            //     int freq = map.get(s.charAt(i)) + 1;
            //     map.put(s.charAt(i), freq);
            // }   


String use s.length(), array int[] nums use nums.length
HashMap uses map.put to set things 

*/

// int[] arr = new int[256];
// Using array as hashmap 

class Solution {
    public int longestPalindrome(String s) {
        
        int[] arr = new int[256];
        int doubleChar = 0, singleChar = 0;
        
        //null check
        if(s.length() == 0){ return 0; }
        
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i)]++;
            
            if(arr[s.charAt(i)] % 2 ==0){
                doubleChar ++;
                singleChar --;
            }else{
                singleChar ++;
            }
            
        }
        
        return singleChar >= 1 ? doubleChar * 2 + 1 : doubleChar * 2;
    }
}


// Hash Map Solution

class Solution {
    public int longestPalindrome(String s) {
        
        HashMap <Character, Integer> map = new HashMap<>();
        int doubleChar = 0, singleChar = 0;
        
        //null check
        if(s.length() == 0){ return 0; }
        
        for(int i = 0; i < s.length(); i++){
            if( ! map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
                singleChar++;
            } else{
                int freq = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), freq);
                
                if(freq % 2 == 0){
                    doubleChar ++;
                    singleChar --;
                }else{
                    singleChar ++;
                }
                
            }
        }
        
        return singleChar >= 1 ? doubleChar * 2 + 1 : doubleChar * 2;
    }
}
