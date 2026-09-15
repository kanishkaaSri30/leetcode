class Solution {
    public TreeNode helper(int[] preorder, int[] inorder, int prelow , int prehigh, int inlow, int inhigh){

        if(prelow > prehigh || inlow > inhigh) return null;
        TreeNode root = new TreeNode(preorder[prelow]);
        int r = 0;
        while(inorder[r] != preorder[prelow]) r++;
        int leftsize = r - inlow;
        root.left = helper(preorder,inorder,prelow+1,prelow+leftsize,inlow,r-1);
        root.right = helper(preorder,inorder,prelow+leftsize+1,prehigh,r+1,inhigh);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        
        int n = preorder.length;
        int[] inorder = Arrays.copyOf(preorder,n);
        Arrays.sort(inorder);
        return helper(preorder,inorder,0,n-1,0,n-1);

        
    }
}