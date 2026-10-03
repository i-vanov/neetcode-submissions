public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    // Start from the root.
    // For each character in the word:

    //     Convert character to index (c - 'a')
    //     If the child node doesn’t exist, create it.
    //     Move to the child.

    // After processing all characters, mark endOfWord = true.
    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';
            // If the char does not exist, create it
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            // Move to the child
            curr = curr.children[i];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                return false;
            }
            curr = curr.children[i];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                return false;
            }
            curr = curr.children[i];
        }
        return true;
    }
}
