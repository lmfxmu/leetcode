// นใหั
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (n > 0) {
                TreeNode tmpNode = queue.poll();
                if (tmpNode != null) {
                    tmp.add(tmpNode.val);
                    if (tmpNode.left != null) {
                        queue.offer(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        queue.offer(tmpNode.right);
                    }
                }
                n--;
            }
            ans.add(tmp);
        }
        return ans;
    }
}