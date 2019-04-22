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
