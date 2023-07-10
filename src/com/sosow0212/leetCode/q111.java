package com.sosow0212.leetCode;

public class q111 {

    static int answer = Integer.MAX_VALUE;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + r;
        } else if (root.right == null) {
            return 1 + l;
        }

        return Math.min(l, r) + 1;
    }
}
