package offer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        System.out.println(solution.reConstructBinaryTree(pre, in));

    }
}
