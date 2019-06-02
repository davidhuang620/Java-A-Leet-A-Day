class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        
        HashMap<Character, List<Character>> map = new HashMap<>();
        createMap(map);

        Queue<String> queue = new LinkedList<>();
        queue.add("");
        int ind = 0;
        while(!queue.isEmpty()){
            String comb = queue.poll();
            if (comb.length() == digits.length()){
                ans.add(comb);
                continue;
            }
            for (char c : map.get(digits.charAt(comb.length()))){
                queue.add(comb + c);
            }           
        }
        
        return ans;
    }
    
    
    private void createMap(HashMap<Character, List<Character>> map){
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
    }
    
}
