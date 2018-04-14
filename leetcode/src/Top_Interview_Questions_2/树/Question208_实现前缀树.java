package Top_Interview_Questions_2.树;

public class Question208_实现前缀树 {

    class TrieNode{
        char val;
        TrieNode[] next = new TrieNode[26];
        boolean isword;

        public TrieNode() {
        }

        public TrieNode(char val) {
            this.val = val;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Question208_实现前缀树() {

        root = new TrieNode();
        root.val = ' ';

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode cur = root;

        for (char ch : word.toCharArray())
        {
            if (cur.next[ch - 'a'] == null)
                cur.next[ch - 'a'] = new TrieNode(ch);

            cur = cur.next[ch - 'a'];
        }

        cur.isword = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode cur = root;

        for (char ch : word.toCharArray())
        {
            if (cur.next[ch - 'a'] == null)
                return false;

            cur = cur.next[ch - 'a'];
        }

        return cur.isword;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode cur = root;

        for (char ch : prefix.toCharArray())
        {
            if (cur.next[ch - 'a'] == null)
                return false;

            cur = cur.next[ch - 'a'];
        }
        return true;
    }
}
