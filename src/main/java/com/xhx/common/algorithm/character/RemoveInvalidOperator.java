package com.xhx.common.algorithm.character;

import java.util.*;

/**
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 */
public class RemoveInvalidOperator {
    public static List<String> removeInvalidParentheses(String s) {
        queue.offer(new StringWraper(s,0));
        vis.add(s);
        boolean flag=false;
        int delNum=0;
        List<String> ans=new ArrayList<String>();
        while (!queue.isEmpty()){
            StringWraper cur=queue.poll();
            if(flag){
                if(cur.delNum == delNum){
                    check(cur,ans);
                }

            }else{
                flag=checkLeft(cur,ans)||checkRight(cur,ans);
                if(flag){
                    delNum = cur.delNum;
                }
            }


        }
        if(ans.size()==0){
            ans.add("");
        }
        return new ArrayList<String>(ans);
    }

    static Set<String> vis=new HashSet<String>();
    static Queue<StringWraper> queue=new LinkedList<StringWraper>();

    public static void check(StringWraper r,List<String> ans){  //查看是否正确
        String s =r.value;
        Stack<Character> st=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='('){
                st.push(c);
            }
            if(c==')'){
                if(st.isEmpty()){
                    return;
                }
                st.pop();
            }
        }
        if(st.isEmpty()){
            ans.add(s);
        }
    }

    public static boolean checkLeft(StringWraper r,List<String> ans){ //检查左边
        String s =r.value;
        //delete right
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else if(s.charAt(i)==')'){
                if(st.isEmpty()){
                    for(int j=i;j>=0;--j){ //删除不符合的')'  多种情况
                        if(s.charAt(j)==')'){
                            String s1=s.substring(0,j)+s.substring(j+1);
                            if(!vis.contains(s1)){
                                vis.add(s1);
                                queue.offer(new StringWraper(s1,r.delNum+1));
                            }
                        }
                    }
                    return false;
                }else{
                    st.pop();
                }
            }
        }
        if(st.isEmpty()){
            ans.add(s);
            return true;
        }
        return false;
    }

    public static boolean checkRight(StringWraper r,List<String> ans){ //检查右边
        String s =r.value;
        //delete right
        Stack<Character> st=new Stack<Character>();
        st.clear();
        for(int i=s.length()-1;i>=0;--i){
            if(s.charAt(i)==')'){
                st.push(s.charAt(i));
            }else if(s.charAt(i)=='('){
                if(st.isEmpty()){
                    for(int j=i;j<s.length();++j){
                        if(s.charAt(j)=='('){  //删除不符合的'(' 多种情况
                            String s1=s.substring(0,j)+s.substring(j+1);
                            if(!vis.contains(s1)){
                                vis.add(s1);
                                queue.add(new StringWraper(s1,r.delNum+1));
                            }
                        }
                    }
                    return false;
                }else{
                    st.pop();
                }
            }
        }
        if(st.isEmpty()){
            ans.add(s);
            return true;
        }
        return false;
    }

    static class StringWraper{
        String value;
        int delNum;
        public StringWraper(String value,int delNum){
            this.value=value;
            this.delNum=delNum;
        }
    }

    public  static void main(String[] arg){
        List<String> list=removeInvalidParentheses(")(");
        for(String s:list) System.out.println(s);

    }
}
