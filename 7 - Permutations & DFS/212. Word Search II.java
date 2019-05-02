/*

1. Trie
2. Contruct preflex set for every single word

        HashSet<String> preSet = new HashSet<>();
        for (String word : words){
            for (int i = 1; i <= word.length(); i++){
                preSet.add(word.substring(0, i));
            }
        }

*/

// 1. Tire

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0
            || words == null || words.length == 0){
            return ans;
        }
        
        TrieNode root = createTrie(words);
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                if (root.next[board[r][c] - 'a'] == null){
                    continue;
                }
                helper(r, c, root, board, ans);
            }
        }
        return ans;        
    }
    
    private void helper(int r, int c, TrieNode node, char[][]board, List<String> ans){
        
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length 
            || board[r][c] == '#'){
            return;
        }
        
        if (node.next[board[r][c] - 'a'] == null){
            return;
        }
        
        node = node.next[board[r][c] - 'a'];
        if (node.word != null){
            ans.add(node.word);
            node.word = null;   // avoid duplciate
        }

        board[r][c] = '#';
        helper(r + 1, c, node, board, ans);
        helper(r - 1, c, node, board, ans);
        helper(r, c + 1, node, board, ans);
        helper(r, c - 1, node, board, ans);
        board[r][c] = node.val;
        
    }    
    
    class TrieNode{
        char val;
        String word;
        TrieNode[] next = new TrieNode[26];
    }
    
    private TrieNode createTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String word : words){
            TrieNode node = root;
            for (char c : word.toCharArray()){
                if (node.next[c - 'a'] == null){
                    node.next[c - 'a'] = new TrieNode();    
                }
                node = node.next[c - 'a'];
                node.val = c;
            }
            node.word = word;
        }
        return root;
    }
    
}

// 2.
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0 || board == null
            || board.length == 0 || board[0].length == 0){
            return new ArrayList<>();
        }
        
        HashSet<String> ans = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));
        HashSet<String> preSet = new HashSet<>();
        for (String word : words){
            for (int i = 1; i <= word.length(); i++){
                preSet.add(word.substring(0, i));
            }
        }
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                helper(r, c, "", preSet, wordSet, ans, board);
            }
        }
        return new ArrayList<>(ans);
    }
    
    private void helper(int r, int c, String word, HashSet<String> preSet, 
                        HashSet<String> wordSet, HashSet<String> ans, char[][]board){

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length
           || !preSet.contains(word + board[r][c])){
            return;
        }
        word = word + board[r][c];
        if (wordSet.contains(word)){
            ans.add(word);
        }
        board[r][c] = ' ';
        helper(r+1, c, word, preSet, wordSet, ans, board);
        helper(r-1, c, word, preSet, wordSet, ans, board);
        helper(r, c+1, word, preSet, wordSet, ans, board);
        helper(r, c-1, word, preSet, wordSet, ans, board);
        board[r][c] = word.charAt(word.length() - 1);
    }
    
}
