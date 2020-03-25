package com.xhx.common.algorithm.tree;

import java.util.*;

/**
 * 用字典树实现自动匹配搜索
 *
 */
public class AutoComplete {
    static class TrieNode{
        String str ="";
        int cnt=0;
        Map<Character,TrieNode> next = new HashMap<>();
    }

    private TrieNode root,current;
    private String stn;
    private PriorityQueue<TrieNode> queue=new PriorityQueue(new Comparator(){

        @Override
        public int compare(Object o1, Object o2) {
            TrieNode n1= (TrieNode)o1;
            TrieNode n2= (TrieNode)o2;
            return n2.cnt-n1.cnt;
        }
    });
    public AutoComplete(String[] sentences,int[] cnts){
        root=new TrieNode();
        for(int i=0;i<sentences.length;i++){
            insert(sentences[i],cnts[i]);
        }
        current=root;

    }

    public void insert(String sentence,int cnt){
        TrieNode cur = root;
        char[] chars = sentence.toCharArray();
        for(char c:chars){
            if(!cur.next.containsKey(c)){
                cur.next.put(c,new TrieNode());
            }
            cur= cur.next.get(c);
        }
        cur.str = sentence;
        cur.cnt+=cnt;
    }

    public List<String> input(char c){
        if(c == '#'){
            insert(stn,1);
            stn="";
            current = root;
            return new ArrayList<>();
        }
        stn=stn+c;

        if(current!= null && current.next.containsKey(c)){
            current=current.next.get(c);
        }else {
            current=null;
            return new ArrayList<>();
        }

        dfs(current);

        List<String> res = new ArrayList<>();
        int n=3;
        while (n>0 &&!queue.isEmpty()){
            res.add(queue.poll().str);
            n--;
        }

        queue.clear();
        return res;

    }

    public void dfs(TrieNode node){
        if(!"".equals(node.str)){
            queue.add(node);
        }
        for(Character c:node.next.keySet()){
            dfs(node.next.get(c));
        }
    }

    public static void main(String[] args) {
        AutoComplete autoComplete=new AutoComplete(new String[]{"i love you", "island","ironman", "i love leetcode"},new int[]{5,3,2,2});

        char[] chars={'i',' ','a','#'};
        for(char c:chars){
            List<String> res= autoComplete.input(c);
            System.out.println(c+":");
            for(String s:res){
                System.out.print(s+",");
            }
            System.out.println();
        }
    }
}
