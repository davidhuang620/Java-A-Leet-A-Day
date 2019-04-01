/*

Ask the interviewer many question to make sure what we are looking for
For example:

Ask if the sum counts on the one same number ? (sum = number + number)
what if there's two of the same number ?

Ask what is more important, how big is the data size, extensibility, does order matters:

Quick add: use hash map
Quick find: if the data size is not large, create another hash set for all of the possible sum

Use array with no hashmap
It means we need to sort it in order to use two pointers algorithm

Quick add: sort it in find()
Quick find: sort it in add()

*/



// For quick add

class TwoSum {

    private HashMap<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.containsKey(number)){
            map.put(number, 2);
        } else{
            map.put(number, 1);
        }       
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int item: map.keySet()){
            if (map.containsKey(value - item)){
                if (value != item * 2 || map.get(item) == 2){
                      return true; 
                }
            } 
        }
        return false;
    }
}


// For quick find 

class TwoSum {

    private HashSet<Integer> set;
    private HashSet<Integer> sum;
    /** Initialize your data structure here. */
    public TwoSum() {
        set = new HashSet<>();
        sum = new HashSet<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (set.contains(number)){
            sum.add(number * 2);
        } else {
            for (int val: set) {
            sum.add(val + number);  
            } 
            set.add(number);
        }
    }   
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return sum.contains(value);
    }
}
