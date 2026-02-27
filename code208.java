// 字典树，记一下,怎么定义类，实例，引用，String的用法
class Trie {
    private Trie[] children;
    private boolean isEnd;
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for (char i : word.toCharArray()) {
            if (node.children[i - 'a'] == null) {
                node.children[i - 'a'] = new Trie();
            }
            node = node.children[i - 'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        if (node.isEnd == false) {
            return false;
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.children[prefix.charAt(i) - 'a'];
        }
        if (node == null) {
            return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */