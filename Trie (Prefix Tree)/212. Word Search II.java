/*

Trie + DFS

*/
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
     class Node{
         char val;
         Node[] next = new Node[26];
         String word;
         Node(char val){
             this.val = val;
         }
     }
     
    public List<String> wordSearchII(char[][] board, List<String> words) {
        
        if (board == null || board.length == 0 || board[0].length == 0 ||
        words == null || words.size() == 0){
            return new ArrayList<String>();
        }
        
        Node root = buildTrie(words);
        
        List<String> ans = new ArrayList<>();
        for (int r = 0; r < board.length; r ++){
            for (int c = 0; c < board[0].length; c ++){
                helper(r, c, root, board, ans);
            }
        }
        return ans;
    }
    
    private void helper(int r, int c, Node root, char[][] board, List<String> ans){
        
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length
            || board[r][c] == '#'){
            return;
        }
        
        char thisChar = board[r][c];
        if (root.next[thisChar - 'a'] == null){
            return;
        }
        
        root = root.next[thisChar - 'a'];
        if (root.word != null){
            ans.add(root.word);
            // avoid duplicate
            root.word = null;
        }   
        
        //avoid step back on the same place & back track
        board[r][c] = '#';
        helper(r+1, c, root, board, ans);
        helper(r-1, c, root, board, ans);
        helper(r, c+1, root, board, ans);
        helper(r, c-1, root, board, ans);
        board[r][c] = root.val;
    }
    
    private Node buildTrie(List<String> words){
        Node root = new Node('0');
        for (String str : words){
            Node pt = root;
            for (int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if (pt.next[c - 'a'] == null){
                    pt.next[c - 'a'] = new Node(c);
                }
                pt = pt.next[c - 'a'];
            }
            // set word 
            pt.word = str;
        }
        return root;
    }
}
