package ListNode;

class  TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }

}

public class MaxDepth {
    public int maxDepth(TreeNode root){

        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }


    public static void main(String[] args) {
        TreeNode root=null;
    }
}
