package tree;

/**
 * Created by Gracecoder on 2017/8/1.
 */

class TrieNode{

    char val;
    boolean isword;
    TrieNode[] next = new TrieNode[26];             //26个字母

    public TrieNode() {
    }

    public TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}



public class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {

        root = new TrieNode();
        root.val = ' ';

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode p = root;
        for (char c : word.toCharArray())
        {
            if (p.next[c-'a']==null)
                p.next[c-'a'] = new TrieNode(c);

            p = p.next[c-'a'];

        }
        p.isword =true;



    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode p = root;
        for (char c : word.toCharArray())
        {
            if (p.next[c-'a']==null)
                return false;

            p = p.next[c-'a'];
        }

        return p.isword;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode p = root;
        for (char c : prefix.toCharArray())
        {
            if (p.next[c-'a']==null)
                return false;

            p = p.next[c-'a'];
        }

        return true;

    }


}


