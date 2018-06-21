package offer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);

        ArrayList<Integer> list = solution.printListFromTailToHead(listNode);
        System.out.println(list);
    }
}
