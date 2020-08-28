package com.xhx.common.algorithm.hashtable;
// Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

// If two nodes are in the same row and column, the order should be from left to right.

// Examples:

// Given binary tree [3,9,20,null,null,15,7],
//    3
//   /\
//  /  \
//  9  20
//     /\
//    /  \
//   15   7
// return its vertical order traversal as:
// [
//   [9],
//   [3,15],
//   [20],
//   [7]
// ]
// Given binary tree [3,9,8,4,0,1,7],
//      3
//     /\
//    /  \
//    9   8
//   /\  /\
//  /  \/  \
//  4  01   7
// return its vertical order traversal as:
// [
//   [4],
//   [9],
//   [3,0,1],
//   [8],
//   [7]
// ]
// Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
//      3
//     /\
//    /  \
//    9   8
//   /\  /\
//  /  \/  \
//  4  01   7
//     /\
//    /  \
//    5   2
// return its vertical order traversal as:
// [
//   [4],
//   [9,5],
//   [3,0,1],
//   [8,2],
//   [7]
// ]


import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
       List<List<Integer>> result=new ArrayList<>();
       if(null == root) return result;

       Map<Integer,List<Integer>> resMap =new HashMap<>();
       Queue<TreeNode> nodeQueue = new LinkedList<>();
       Queue<Integer> vectorQueue=new LinkedList<>();

       nodeQueue.add(root);
       vectorQueue.add(0);

       while (!nodeQueue.isEmpty()){
           TreeNode node=nodeQueue.poll();
           Integer vector = vectorQueue.poll();

           if(!resMap.containsKey(vector)){
               resMap.put(vector,new ArrayList<>());
           }

           resMap.get(vector).add(node.val);
           if(null!=node.left){
               nodeQueue.add(node.left);
               vectorQueue.add(vector-1);
           }

           if(null!=node.right){
               nodeQueue.add(node.right);
               vectorQueue.add(vector+1);
           }
       }
        List<Integer> vectorList=new ArrayList<>(resMap.keySet());
        vectorList.sort(Comparator.naturalOrder());
        for(Integer vector:vectorList){
            result.add(resMap.get(vector));

        }
        return  result;
    }
}
