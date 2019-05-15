class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) return ans;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String cpdomain : cpdomains){
            String[] cpArr = cpdomain.split(" ");
            int count = Integer.parseInt(cpArr[0]);
            String domain = cpArr[1];
            for (int i = domain.length() - 1; i >= 0; i--){
                if (domain.charAt(i) == '.' || i == 0){
                    int start = i == 0 ? i : i + 1; 
                    map.put( domain.substring(start, domain.length()),
                    map.getOrDefault(domain.substring(start,cpArr[1].length()), 0) 
                                    + count);
                }
            }
        }
        for (String key : map.keySet()){
            ans.add(map.get(key) + " " + key);
        }
        return ans;
    }
}
