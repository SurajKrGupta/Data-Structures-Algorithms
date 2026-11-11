/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>res=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        if(root==null) return res;
        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();
            Double sum=0d;
            for(int i=0;i<n;i++){
                TreeNode t=q.poll();
                sum+=t.val;
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            res.add(sum/n);

        }
        return res;
    }
}