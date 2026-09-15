class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        if (isSiblings(root, xx.val, yy.val)) return false;

        return level(root, xx.val, 0) == level(root, yy.val, 0);
    }

    TreeNode findNode(TreeNode node, int val) {
        if (node == null) return null;
        if (node.val == val) return node;

        TreeNode left = findNode(node.left, val);
        if (left != null) return left;

        return findNode(node.right, val);
    }

    boolean isSiblings(TreeNode node, int x, int y) {
        if (node == null) return false;

        if (node.left != null && node.right != null) {
            if ((node.left.val == x && node.right.val == y) ||
                (node.left.val == y && node.right.val == x)) return true;
        }

        return isSiblings(node.left, x, y) || isSiblings(node.right, x, y);
    }

    int level(TreeNode node, int val, int l) {
        if (node == null) return 0;
        if (node.val == val) return l;

        int left = level(node.left, val, l + 1);
        if (left != 0) return left;

        return level(node.right, val, l + 1);
    }
}