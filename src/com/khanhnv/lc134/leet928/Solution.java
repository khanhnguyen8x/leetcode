package com.khanhnv.lc134.leet928;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 */
class Solution {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> preorder = new ArrayList<>();
    if (root == null) {
      return preorder;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      // get top node in stack
      TreeNode node = stack.peek();
      // save val
      preorder.add(node.val);
      // remove top node
      stack.pop();

      // push the right children first
      if (node.right != null) {
        stack.push(node.right);
      }

      // push the left children later, the left children will become top of stack
      if (node.left != null) {
        stack.push(node.left);
      }
    }

    return preorder;
  }

  public List<Integer> preorderTraversalV2(TreeNode root) {
    List<Integer> preorder = new ArrayList<>();
    if (root == null) {
      return preorder;
    }
    preorderTraversalRecursive(root, preorder);

    return preorder;
  }

  public void preorderTraversalRecursive(TreeNode root, List<Integer> preorder) {
    if (root == null) {
      return;
    }

    // Pre-order traversal is to visit the root first.
    preorder.add(root.val);

    // Then traverse the left subtree.
    preorderTraversalRecursive(root.left, preorder);

    // Finally, traverse the right subtree.
    preorderTraversalRecursive(root.right, preorder);
  }
}