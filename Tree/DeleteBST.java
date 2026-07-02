class DeleteBST{
    public TreeNode helper(TreeNode root) {
        if(root==null) {
            return null;
        }
        while(root.left!=null) {
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if(root.left==null && root.right==null) {
                return null;
            }
            if(root.left==null && root.right!=null) {
                return root.right;
            }
            if(root.left!=null && root.right==null) {
                return root.left;
            }
            if(root.left!=null && root.right!=null) {
            TreeNode s = helper(root.right);
            root.val = s.val;
            root.right = deleteNode(root.right, s.val);
            }
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}