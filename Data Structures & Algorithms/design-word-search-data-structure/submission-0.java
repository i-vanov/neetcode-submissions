public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.endOfWord;
        }

        char c = word.charAt(index);

        if (c != '.') {
            int i = c - 'a';

            if (node.children[i] == null) {
                return false;
            }

            return dfs(node.children[i], word, index + 1);
        }

        // '.': try every possible child
        for (TrieNode child : node.children) {
            if (child != null && dfs(child, word, index + 1)) {
                return true;
            }
        }
        return false;
    }
}
