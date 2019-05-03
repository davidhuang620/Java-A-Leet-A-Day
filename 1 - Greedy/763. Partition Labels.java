class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        if (S == null || S.length() == 0) return ans;
        
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++){
            last[S.charAt(i) - 'a'] = i;
        }
        
        int endOfPart = 0, startOfPart = 0;
        for (int i = 0; i < S.length(); i++){
            endOfPart = Math.max(endOfPart, last[S.charAt(i) - 'a']);
            if (i == endOfPart){
                ans.add(endOfPart - startOfPart + 1);
                startOfPart = i + 1;
            }
        }
        return ans;
    }   
}
