/*

*/

// Using Lambda 
        Queue<Integer> minHeap = 
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
  
  
// Using comparator
    Queue<Integer> minHeap = new PriorityQueue<>(new CompareFreq);
    
    // aside from the function
    // also be aware if we have access to the variable, if not, need to declare it as global variable
    class CompareFreq implements Comparator<Integer>{
         // notice that we need to use Integer insead of int
        public int compare(Integer a, Integer b){
            return map.get(a) - map.get(b);
        }
    }
    
/*  
  
*/


class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        if (nums == null|| nums.length == 0){
            return new ArrayList<Integer>();
        }
        
        Queue<Integer> minHeap = new PriorityQueue<>(new CompareFreq());
        
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // use keySets to avoid duplicates
        for (int num : map.keySet()){
            minHeap.add(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        List<Integer> ans = new ArrayList<>(minHeap);
        // output is reverse
        Collections.reverse(ans);
        return ans;        
    }
    
    class CompareFreq implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            return map.get(a) - map.get(b);
        }
    }
    
}


class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        if (nums == null|| nums.length == 0){
            return new ArrayList<Integer>();
        }
        
        Queue<Integer> minHeap = 
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // use keySets to avoid duplicates
        for (int num : map.keySet()){
            minHeap.add(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        List<Integer> ans = new ArrayList<>(minHeap);
        // output is reverse
        Collections.reverse(ans);
        return ans;        
    }
    
    // class CompareFreq implements Comparator<Integer>{
    //     public int compare(Integer a, Integer b){
    //         return map.get(a) - map.get(b);
    //     }
    // }
    
}

