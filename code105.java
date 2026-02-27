//  拆解子问题，递归，需要记，利用中序序列信息来拆解左右子树递归
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int n = preorder.length;
        // 左子树大小
        int leftSize = find(preorder[0], inorder);
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, leftSize + 1, n);
        // 左子树
        TreeNode left = buildTree(pre1, in1);
        // 右子树
        TreeNode right = buildTree(pre2, in2);
        TreeNode root = new TreeNode(preorder[0], left, right);
        return root;

    }
    public int find(int item, int [] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == item) {
                return i;
            }
        }
        return -1;
    }
}


//  用哈希表和数组上下标优化,这个数组上下标想了挺久的
class Solution {
    public Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode dfs(int[] preorder, int preleft, int preright, int inleft, int inright) {
        if (preleft >= preright) {
            return null;
        }

        // 准备计算根节点的左子树
        int leftSize = map.get(preorder[preleft]);
        leftSize -= inleft;
        // 
        // （根） 左  右
        // 前 （根） 后
        TreeNode left = dfs(preorder, preleft + 1, preleft + 1 + leftSize, inleft, inleft + leftSize);
        TreeNode right = dfs(preorder, preleft + 1 + leftSize, preright, inleft + leftSize + 1, inright);
        return new TreeNode(preorder[preleft], left, right);

    }
    
}