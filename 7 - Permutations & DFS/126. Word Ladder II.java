/*
The solution contains two steps 
1. Use BFS to construct a graph. 
2. Use DFS to construct the paths from end to start.

The reason we construct the path from end to start at the second step is because is faster,
there may a lof way to expands path from start, but not all the path leads to end,
if we start from end to start, than it is guarantee we only search on paths that leads from end to start.

Think in this way:
Since we don't know how the graph looks like, we first use BFS to construct the shortest "graph" to the endWord.
Then use DFS to contruct all the path from the graph.

The first step BFS is quite important. I summarized three tricks

Using a MAP to store the min ladder of each word, or use a SET to store the words visited in current ladder, 
when the current ladder was completed, delete the visited words from unvisited. That's why I have two similar solutions.

Use Character iteration to find all possible paths. 
Do not compare one word to all the other words and check if they only differ by one character.

One word is allowed to be inserted into the queue only ONCE. See my comments.

*/


class Solution {
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {

        if (start == null || end == null || wordList == null
           || start.length() == 0 || end.length() == 0 || wordList.size() == 0){
            return new ArrayList<>();
        }
        
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> prevNodes = new HashMap<>();

        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        // remove from the wordSet, because we have already "visited" it 
        // so we won't go back on the start
        wordSet.remove(start);
        boolean found = false;

        
        while (!queue.isEmpty() && !found){

            int qSize = queue.size();
            for (int i = 0; i < qSize; i++){
                String str = queue.poll();
                // The level thing is neccessary
                // there might be other paths that connect to the target word that could be found 
                // at the same level we found the target word
                for (int j = 0; j < str.length(); j++){
                    char[] strArr = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++){
                        strArr[j] = c;
                        String nextStr = String.valueOf(strArr);
                        
                        if (wordSet.contains(nextStr)){
                            if (!prevNodes.containsKey(nextStr)){
                                prevNodes.put(nextStr, new ArrayList<>());   
                            } 
                            prevNodes.get(nextStr).add(str); 
                            // we don't want to remove it from wordSet right now
                            // since there may be other nodes pointing to this node
                            // we add it into a visited set 
                            // and remove it at the end of this level 
                            // the if statement is Key, Avoid Duplicate queue insertion
                            if (visited.add(nextStr)){
                                queue.add(nextStr);
                            }
                        }
                        
                        if (nextStr.equals(end)){
                            found = true;
                        }
                        
                    }
                }
            } // end of this level
            
            wordSet.removeAll(visited);
            visited.clear();
        } // end of BFS
        
        // BackTracing the path 
        helper(start, end, prevNodes, new LinkedList<String>(Arrays.asList(end)), ans);
        return ans;
    }
    
    private void helper(String start, String str, HashMap<String, List<String>> prevNodes,
                        LinkedList<String> path, List<List<String>> ans){
        
        if (str.equals(start)){
            ans.add(new ArrayList<String>(path));
            return;
        }
        
        if (!prevNodes.containsKey(str)){
            return;
        }
        
        for (String prev : prevNodes.get(str)){
            // Since we are backTracing, we use add/ remove from the first item
            // and we NEED TO use a linkedlist, for efficiency 
            path.addFirst(prev);
            helper(start, prev, prevNodes, path, ans);
            path.removeFirst();
        }
        
    }
}


