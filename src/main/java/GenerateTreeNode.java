import java.util.Deque;
import java.util.LinkedList;


public class GenerateTreeNode {
    public static TreeNode generateTreeNode(Integer[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int len = nums.length;
        int index = 0;
        TreeNode head = new TreeNode(nums[index]);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(head);
        TreeNode cur;
        while (index < len) {
            index++;
            if (index >= len) return head;
            cur = nodeQueue.poll();
            Integer left = nums[index];
            if (left != null) {
                cur.left = new TreeNode(left);
                nodeQueue.offer(cur.left);
            }

            index++;
            if (index >= len) return head;
            Integer right = nums[index];
            if (right != null) {
                cur.right = new TreeNode(right);
                nodeQueue.offer(cur.right);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Integer[] data = {1, null, 2, 2, 32, 31, 3, 23, 1, 23, 123, 12, 3, 12, 31, 23, 2};
        TreeNode node = GenerateTreeNode.generateTreeNode(data);
        System.out.println();
    }

}
