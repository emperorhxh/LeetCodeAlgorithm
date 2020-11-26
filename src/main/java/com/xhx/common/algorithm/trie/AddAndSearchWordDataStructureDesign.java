package com.xhx.common.algorithm.trie;

// Design a data structure that supports the following two operations:

// void addWord(word)
// bool search(word)
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

// For example:

// addWord("bad")
// addWord("dad")
// addWord("mad")
// search("pad") -> false
// search("bad") -> true
// search(".ad") -> true
// search("b..") -> true

// Note:
    // You may assume that all words are consist of lowercase letters a-z.

public class AddAndSearchWordDataStructureDesign {
    public class TrieNode{
        TrieNode[] children=new TrieNode[26];
        String item="";
    }
    TrieNode root=new TrieNode();

    public void addWord(String str){
        TrieNode node =root;
        for (char c:str.toCharArray()){
            if(node.children[c-'a'] == null){
                node.children[c-'a'] =new TrieNode();
            }
            node=node.children[c-'a'];
        }
        node.item=str;

    }
    public boolean search(String str){
        return match(str.toCharArray(),0,root);
    }

    public boolean match(char[] chars,int matchedCount,TrieNode node){
        if(matchedCount == chars.length){
            return !node.item.equals("");
        }
        if(chars[matchedCount]=='.'){
            for(int i=0;i<node.children.length;i++){
                if(node.children[i]!=null){
                    if(match(chars,matchedCount+1,node.children[i])){
                        return true;
                    }
                }
            }
        }else {
            return node.children[chars[matchedCount]-'a']!=null && match(chars,matchedCount+1,node.children[chars[matchedCount]-'a']);
        }
        return false;
    }
}
