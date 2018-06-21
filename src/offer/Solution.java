package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {

    // 1.二维数组中的查找
    public boolean Find(int target, int[][] array) {

        int row = array.length;
        if (row == 0)
            return false;

        int col = array[0].length;
        if (col == 0)
            return false;

        if (target < array[0][0] || target > array[row - 1][col - 1])
            return false;

        for (int i = 0; i < row; ++i) {
            if (array[i][col - 1] >= target) {
                for (int j = 0; j < col; ++j) {
                    if (array[i][j] == target)
                        return true;
                }
            }
        }
        return false;
    }

    // 2.替换空格
    public String replaceSpace(StringBuffer str) {

        StringBuilder result = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            if (str.charAt(i) != ' ') {
                result.append(str.charAt(i));
            } else {
                result.append("%20");
            }
        }

        return result.toString();
    }

    // 3.从尾到头打印链表
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        if (listNode != null)
            list.add(0, listNode.val);
        else
            return list;

        if (listNode.next != null)
            list.addAll(0, printListFromTailToHead(listNode.next));

        return list;
    }

    // 4.重建二叉树
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || in == null) {
            return null;
        }

        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        if (pre.length != in.length) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }

    // 5.用两个栈实现队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("栈为空！");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
