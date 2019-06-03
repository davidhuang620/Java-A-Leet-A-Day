class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        if (paths == null || paths.length == 0) return ans;
        
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : paths){
            String[] strArr = str.split(" ");
            for (int i = 1; i < strArr.length; i++){
                int start = strArr[i].indexOf("(");
                int end = strArr[i].indexOf(")") + 1;
                String text = strArr[i].substring(start, end);
                if (!map.containsKey(text)){
                    map.put(text, new ArrayList<>());
                }
                map.get(text).add(strArr[0] + "/" + strArr[i].substring(0, start));
            }
        }
        
        for (String key : map.keySet()){
            List<String> dup = map.get(key);
            if (dup.size() > 1){
                ans.add(dup);
            }
        }
        return ans;
    }
}
