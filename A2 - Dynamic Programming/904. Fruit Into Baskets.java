
// Update 


// Update the first occurance of fruit 2 after the last occurance of fruit 1

class Solution {
    public int totalFruit(int[] tree) {
        
        if (tree == null || tree.length == 0){
            return 0;
        }
        
        HashMap <Integer, Integer> map = new HashMap<>();
        int b1 = tree[0], b2 = tree[0];
        map.put(b1, 0);
        map.put(b2, 0);
        int start = 0, max = 0;
        for (int i = 0; i < tree.length; i++){   
            if (tree[i] == b1){
                if (map.get(b1) < map.get(b2)){
                    map.put(b1, i);
                } 
                continue;
            }
            if (tree[i] == b2){
                if (map.get(b2) < map.get(b1)){
                    map.put(b2, i);
                }
                continue;
            }
            max = Math.max(max, i - start);
            if (map.get(b1) > map.get(b2)){
                start = map.get(b1);
                b2 = tree[i];
                map.put(b2, i);
            } else {
                start = map.get(b2);
                b1 = tree[i];
                map.put(b1, i);
            }
        } 
        
        return Math.max(max, tree.length - start);

    }
}
