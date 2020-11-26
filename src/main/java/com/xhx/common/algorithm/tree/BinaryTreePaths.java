package com.xhx.common.algorithm.tree;// Given a binary tree, return all root-to-leaf paths.

// For example, given the following binary tree:

//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:

// ["1->2->5", "1->3"]

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();

        if(root == null) {
            return result;
        }
        
        helper(new String(), root, result);
        
        return result;
    }
    private void helper(String current,TreeNode node,List<String> result){
        if(node.left==null&&node.right==null){
            result.add(current+node.val);
            return;
        }
        if(node.left !=null){
            helper(current+node.val+"->",node.left,result);
        }
        if(node.right !=null){
            helper(current+node.val+"->",node.right,result);
        }
    }
}
