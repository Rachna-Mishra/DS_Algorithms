package Algorithms;

// User function Template for Java
public class Trie {

    static class Node{
        Node[] children;
        boolean eow;
        public Node(){
            children = new Node[26];
            for(int i = 0; i<26; i++){
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public Trie() {
        root = new Node();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        Node cur = root;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null){
                cur.children[idx] = new Node();

            }
            if(i == word.length()-1){
                cur.children[idx].eow = true;
            }
            cur = cur.children[idx];
        }
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        Node cur = root;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null){
                return false;
            }
            if(i == word.length()-1 && cur.children[idx].eow == false){
                return false;
            }
            cur = cur.children[idx];
        }
        return true;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        Node cur = root;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null){
                return false;
            }
            cur = cur.children[idx];
        }
        return true;
    }
}