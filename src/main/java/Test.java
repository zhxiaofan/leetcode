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
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        if(root==null) return 0;

        postOrder(root);

        return maxSum;
    }

    //     define return value
//     当返回值为空则不为bst
    int[] postOrder(TreeNode root){
        if(root==null) return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};

        int[] left = postOrder(root.left);

        int[] right = postOrder(root.right);

        if(left==null||right==null) return null;

        if(root.val<left[0]||root.val>right[1]) return null;

        int sum = left[2]+right[2]+root.val;
        maxSum = Math.max(maxSum,sum);

//         以root为根节点的树 的最大值和最小值
        int min = Math.min(left[0],root.val);

        int max = Math.max(right[1],root.val);

        return new int[]{min,max,sum};

    }



    public static void main(String[] args) {
      /*  Integer[] data = {1,4,3,2,4,2,5,null,null,null,null,null,null,4,6};
        TreeNode root = GenerateTreeNode.generateTreeNode(data);

        Solution s = new Solution();
        System.out.println(s.maxSumBST(root));*/
        System.out.println(2^1-1);

    }
}