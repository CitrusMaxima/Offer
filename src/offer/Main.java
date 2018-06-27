package offer;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(1);
        treeNode.right.left = new TreeNode(12);
        System.out.println("result:" + solution.PrintFromTopToBottom(treeNode));

    }
}
