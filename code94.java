// µÝ¹é
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        dfs(root, ans);
        return ans;


    }
    
    public void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return ;
        }
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }
}

// µü´ú£¬ÉÔÄÑ
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (stack.size() > 0 || root != null) {

            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }

        }

        return ans;


    }
    

}