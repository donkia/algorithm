package leetcode;

/**
 * 문제 : https://leetcode.com/problems/validate-binary-search-tree/
 * 레벨 : Medium
 * 결과 : 참고 후 해결(runtime 1ms faster than 57.19%, memory 44.7MB less than 8.50%)
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    ;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

public class ValidateBinarySearchTree {

    public boolean isBSTHelper(TreeNode node, Integer lower_limit, Integer upper_limit) {
        if ((lower_limit != null) && (node.val <= lower_limit))
            return false;
        if ((upper_limit != null) && (upper_limit <= node.val))
            return false;

        boolean left = node.left != null ? isBSTHelper(node.left, lower_limit, node.val) : true;
        if (left) {
            boolean right = node.right != null ? isBSTHelper(node.right, node.val, upper_limit) : true;
            return right;
        } else
            return false;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return isBSTHelper(root, null, null);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

    }
}
