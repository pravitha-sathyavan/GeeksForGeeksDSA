/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. 
There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.

*/

class TrieNode{
    TrieNode[] childNodes;
    boolean wordEnd;

    TrieNode(){
        childNodes = new TrieNode[26];
        wordEnd = false;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;

        for(char c: word.toCharArray()){
            if(current.childNodes[c-'a']==null){
                current.childNodes[c-'a'] = new TrieNode();
            }
            current = current.childNodes[c-'a'];
        }

        current.wordEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;

        for(char c: word.toCharArray()){
            if(current.childNodes[c-'a']==null){
                return false;
            }
            current = current.childNodes[c-'a'];
        }
        return current.wordEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for(char c: prefix.toCharArray()){
            if(current.childNodes[c-'a']==null){
                return false;
            }
            current = current.childNodes[c-'a'];
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
