class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if (digits == null || digits.length() == 0){
            return ans;
        }
        String[] map = new String[10];
        putPhoneNumber(map);
        helper(0, "", map, digits, ans);
        return ans;
    }
    
    private void helper(int index, String subString, String[] map,
                        String digits, List<String> ans){
        if (index == digits.length()){
            ans.add(subString);
            return;
        }
        String str = map[Character.getNumericValue(digits.charAt(index))];
        for (int i = 0; i < str.length(); i ++){
            helper(index + 1, subString + str.charAt(i), map, digits, ans);
        }
    }
    
    private void putPhoneNumber(String[] map){
        map[0] = " ";
        map[1] = "";
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
    }
}
