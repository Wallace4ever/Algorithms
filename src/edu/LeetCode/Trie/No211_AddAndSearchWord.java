package edu.LeetCode.Trie;

public class No211_AddAndSearchWord {
    private TrieNode root;

    /** Initialize your data structure here. */
    public No211_AddAndSearchWord() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        return search(word, 0, node);
    }

    private boolean search(String word, int index,TrieNode node) {
        if (index == word.length()) {
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if (ch == '.') {

            for (TrieNode next : node.links) {
                if (next != null && search(word, index + 1, next))
                    return true;
            }
            return false;
        } else {
            return node.containsKey(ch) && search(word, index + 1, node.get(ch));
        }
    }

    public static void main(String[] args) {
        No211_AddAndSearchWord ins = new No211_AddAndSearchWord();
        ins.addWord("a");
        ins.addWord("a");
        ins.addWord("and");
        ins.addWord("an");
        ins.addWord("add");

        System.out.println(ins.search(".at"));
        System.out.println(ins.search(".at"));
        System.out.println(ins.search("an."));
        System.out.println(ins.search("an."));
        System.out.println(ins.search("a.d."));
        System.out.println(ins.search("b."));
        System.out.println(ins.search("a.d"));
        System.out.println(ins.search("a."));
    }
}
