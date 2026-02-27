// 外部变量计数
class Solution {
    public int num;
    public int answer;
    public int kthSmallest(TreeNode root, int k) {
        num = k;
        dfs(root);
        return answer;
    }
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        num--;
        if (num == 0) {
            answer = root.val;
            return;
        }
        dfs(root.right);
        return;
    }
}


// 其他方法实在是太麻烦，感觉没必要学，值得一看的就是
// 哈希表记一下，还有一个把外部变量answer改成函数内部返回的方式。