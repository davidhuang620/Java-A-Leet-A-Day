/*
The key here is to follow the steps one by one without mixing them together
It will avoid many corner cases 
Step 1:
Add every char into the graph and indegree
Step 2:
Add every edges into the graph and update the indegree
Step 3:
Add every char in the indegree that has indegree == 0 into the queue
Step 4:
Perform Topological Sorting

*/
class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0){
            return "";
        }
        if (words.length == 1){
            return words[0];
        }
        
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        
        // first put every char into the graph
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < words[i].length(); j++){
                char c = words[i].charAt(j);
                if (!graph.containsKey(c)){
                        graph.put(c, new HashSet());
                        indegree.put(c, 0);
                }
            }
        }
        
        // then put every edges into indegree
        // comparing two words at i and i+1
        for (int i = 0; i + 1 < words.length; i++){
            int index = 0;
            while (index < words[i].length() && index < words[i + 1].length()){
                char first = words[i].charAt(index);
                char sec = words[i + 1].charAt(index);
                if (first != sec){
                /** WARNING: we must check if we already build curChar -> nextChar relationship in graph
                 * if it contains, we cannot update inDegree map again. Otherwise, this nextChar
                 * will never be put in the queue when we do BFS traversal
                 * eg: for the input: {"za", "zb", "ca", "cb"}, we have two pairs of a -> b relationship
                 * if we increase inDegree value of 'b' again, the final result will not have 'b', since 
                 * inDegree of b will stay on 1 when queue is empty 
                 * correct graph: a -> b, z -> c
                 * incorrect graph: a -> b, a -> b, z -> c
                 * */
                    if (!graph.get(first).contains(sec)){
                        graph.get(first).add(sec);
                        indegree.put(sec, indegree.get(sec) + 1);
                    }
                    break;
                }
                index++;
            }
        }
        
        // Add 0 indegree into the queue
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()){
            if (indegree.get(c) == 0){
                queue.add(c);
            }
        }

        // Then perform Topoligical sorting        
        String ans = "";
        while (!queue.isEmpty()){
            char c = queue.poll();
            ans = ans + c;
            if (graph.get(c).size() > 0){
                for (char next : graph.get(c)){
                    indegree.put(next, indegree.get(next) - 1);
                    if (indegree.get(next) == 0){
                        queue.add(next);
                    }
                }
            }
        }
        
        // There may be char circle in the graph that is not added into the queue
        // Therefore, we need to check the size 
        return ans.length() == graph.size() ? ans : "";
        
    }
}
