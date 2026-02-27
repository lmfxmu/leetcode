/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//  非常非常巧妙的算法，其实还是要理解题意，这一题比较特殊。
//  此前我的想法也类似于这个，但是一直想不到用什么来标记这个
//  特殊的信息，即左右子树会有p或者q或者都有。如果细细盘一下
//  就会发现返回值的巧妙之处，只要返回p或者q或者祖先节点就可以
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终点，找到p或者q或者null.
        // 哪怕q在p下面也没事，那也直接返回最上层的q就行
        // 如果q不在p下面，那此刻我们就正在用节点来传递
        // 孩子有p或者q这个信息
        if (root == null || root == p || root == q) {
            return root;
        }
        // 获得左右子树的孩子信息
        TreeNode leftC = lowestCommonAncestor(root.left, p ,q);
        TreeNode rightC = lowestCommonAncestor(root.right, p ,q);
        // 找到最近公共祖先，且只会单边传递上去，另外一边全是null
        if (leftC != null && rightC != null) {
            return root;
        }
        // 如果左右子树存在空，那就传递非空节点或者空节点。
        if (leftC != null) {
            return leftC;
        }
        return rightC;

    }
}


//  比较通用的解法，记录p之前的祖先节点，然后标记visit，
//  再从q往前走一遍，返回最早的visit
class Solution {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = null;
        TreeNode tmp = p;

        dfs(root);
        map.put(null, root);
        
        while (tmp != null) {
            set.add(tmp);
            tmp = map.get(tmp);
        }

        tmp = q;
        while (tmp != null) {
            if (set.contains(tmp)) {
                ans = tmp;
                break;
            }
            tmp = map.get(tmp);
        }
        return ans;

    }
    // 记录祖先信息
    public void dfs(TreeNode root) {
        if (root.left != null) {
            map.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            dfs(root.right);
        }
    }
}