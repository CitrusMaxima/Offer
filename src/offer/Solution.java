package offer;

import java.util.ArrayList;

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

        StringBuffer result = new StringBuffer();
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

}
