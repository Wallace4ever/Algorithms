package edu.LeetCode.Trie;

public class No208_ImplementTriePrefixTree {
    private TrieNode root;

    public No208_ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (!node.containsKey(curr)) {
                node.put(curr, new TrieNode());
            }
            node = node.get(curr);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (node.containsKey(curr)) {
                node = node.get(curr);
            } else {
                return false;
            }
        }
        //如果不是end说明word是存入前缀树的另一个词的前缀
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curr = prefix.charAt(i);
            if (node.containsKey(curr)) {
                node = node.get(curr);
            } else {
                return false;
            }
        }
        //只要没返回false则说明前缀都匹配了
        return true;
    }
}

class TrieNode{
    TrieNode[] links;
    boolean isEnd;

    public TrieNode() {
        links = new TrieNode[26];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch-'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}