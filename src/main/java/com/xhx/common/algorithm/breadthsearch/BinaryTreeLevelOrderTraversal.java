package com.xhx.common.algorithm.breadthsearch;
// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal test=new BinaryTreeLevelOrderTraversal();
        TreeNode root=test.new TreeNode(3);
        root.left=test.new TreeNode(9);
        root.right=test.new TreeNode(20);
        root.left.left=test.new TreeNode(15);
        root.left.right=test.new TreeNode(7);
        List<List<Integer>> res=test.levelOrder(root);
        for(List<Integer> integerList:res){
            for(Integer i:integerList){
                System.out.println(i+",");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(null != node.left) queue.add(node.left);
                if(null != node.right) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
