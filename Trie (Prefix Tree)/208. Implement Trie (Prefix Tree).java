class Trie {

    class Node{
        char prefix;
        Node[] next;
        boolean isWord;
        Node(char prefix){
            this.prefix = prefix;
            this.next = new Node[26];
            this.isWord = false;
        }
    }
    
    Node root;
    public Trie() {
        root = new Node('0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node pt = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (pt.next[c - 'a'] == null){
                pt.next[c - 'a'] = new Node(c);
            }
            pt = pt.next[c - 'a'];
        }   
        pt.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node pt = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (pt.next[c - 'a'] == null){
                return false;
            }
            pt = pt.next[c - 'a'];
        } 
        return pt.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node pt = root;
        for (int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if (pt.next[c - 'a'] == null){
                return false;
            }
            pt = pt.next[c - 'a'];
        }
        return true;
    }
}
