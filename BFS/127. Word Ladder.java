/*
The first intuition for this problem is to build a graph whose nodes represent strings and edges connect strings that are only 1 character apart, and then we apply BFS from the startWord node. If we find the endWord, we return the level count of the bfs. This intuition is correct, but there are some places that we can save time.

When we build adjacency list graph, we don't use two loops to check every pair of string to see if they are 1 character apart. Instead, we make changes to current string to obtain all the strings we can reach from current node, and see if it is in the wordList. Thus, there are currentString.length() * 25 case we need to check for every node. This is faster when the wordList set is large, since the check-every-pair method need wordList.size() * currentString.length() for each node. Otherwise, your may exceed the running time limit.

For the strings we visited, we remove it from the wordList. This way we don't need to mark visited using another HashSet or something.

Actually, we don't even need to build the adjacency list graph explicitly using a HashMap<String, ArrayList>, since we keep all the nodes we can reach in the queue of each level of BFS. This can be seen as the keys of the HashMap are the strings that in the queue, and values are the strings that satisfy the 1 character apart in the wordList. Thus, we avoid the time cost of build map for those nodes we don't need to visit.


*/


class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        
        if (begin == null || begin.length() == 0 || end == null || end.length() == 0 || wordList == null || wordList.size() == 0){
            return 0;
        }
        
        if (begin.equals(end)){ return 1;}
        
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        
        // Trick
        // conver the list to a set for faster look up
        HashSet<String> set = new HashSet<>();
        for (String item: wordList){
            set.add(item);
        }
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++){
                String word = queue.poll();
                
                // Instead of comparing each char for two words
                // loop through all the possible combination of the next word
                for (int j = 0; j < begin.length(); j++){
                    for (char c = 'a'; c <= 'z'; c++){
                    
                        // use word.charAt() to compare with char instead of word[i]
                        // Make sure of the big O
                        if (word.charAt(j) != c){
                            String newWord = word.substring(0, j) + c + word.substring(j + 1, begin.length());
                            if (set.contains(newWord)){
                                if(newWord.equals(end)){
                                     return level;
                                }   
                                
                                // Instead of keep a hashset for visited word 
                                // remove it from the set so we won't revisit a word twice 
                                queue.add(newWord);
                                set.remove(newWord);
                            } 
                            
                        }
 
                    }

                }

            }

        }
        return 0;
        
}
}
