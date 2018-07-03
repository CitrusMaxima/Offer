package offer;

import java.util.*;

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
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

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

    // 6.旋转数组的最小数字
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        while (array[left] >= array[right]) {
            if (right - left <= 1) {
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            if (array[left] == array[mid] && array[mid] == array[right]) {
                if (array[left + 1] != array[right - 1]) {
                    mid = array[left + 1] < array[right - 1] ? left + 1 : right - 1;
                } else {
                    left++;
                    right--;
                }
            } else {
                if (array[left] <= array[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }

        return array[mid];
    }

    // 7.斐波那契数列
    public int Fibonacci(int n) {
        int result = 0;
        int preOne = 1;
        int preTwo = 0;

        if (n == 0) {
            return preTwo;
        }
        if (n == 1) {
            return preOne;
        }
        for (int i = 2; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

    // 8.跳台阶
    public int JumpFloor(int target) {
        int result = 0;
        int preOne = 1;
        int preTwo = 0;

        if (target == 0) {
            return preTwo;
        }
        if (target == 1) {
            return preOne;
        }
        for (int i = 2; i <= target + 1; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

    // 9.变态跳台阶
    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }

    // 10.矩形覆盖
    public int RectCover(int target) {
        int number = 1;
        int sum = 1;
        if (target <= 0)
            return 0;
        if (target == 1) {
            return 1;
        }

        while (target-- >= 2) {
            sum += number;
            number = sum - number;
        }
        return sum;
    }

    // 11.二进制中1的个数
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;  //只要n不为0则其至少有一个1
            n = n & (n - 1);
        }
        return count;
    }

    // 12.数值的整数次方
    public double Power(double base, int exponent) {
        double res = 0;
        if (base == 0.0) {
            return 0;
        }
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent > 0) {
            res = mutiply(base, exponent);
        } else {
            res = mutiply(1 / base, -exponent);
        }
        return res;
    }

    private double mutiply(double base, int e) {
        double sum = 1;
        for (int i = 0; i < e; i++) {
            sum = sum * base;
        }
        return sum;
    }

    // 13.调整数组顺序使奇数位于偶数前面
    public void reOrderArray(int[] array) {

        if (array == null || array.length == 0)
            return;

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            if (array[i] % 2 != 0) {
                while (j >= 0) {
                    if (array[j] % 2 != 0) {
                        break;
                    } else {
                        int t = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = t;
                        j--;
                    }
                }
            }
            array[j + 1] = temp;
        }
    }

    // 14.链表中倒数第k个节点
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 1) {
            if (fast.next != null)
                fast = fast.next;
            else
                return null;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    // 15.反转链表
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }

        return newHead;
    }

    // 16.合并两个排序的链表
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        ListNode newHead = null;
        if (list1.val <= list2.val) {
            newHead = list1;
            newHead.next = Merge(list1.next, list2);
        } else {
            newHead = list2;
            newHead.next = Merge(list1, list2.next);
        }

        return newHead;
    }

    // 17.树的子结构
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);
            }

            if (!result) {
                return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    private boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return doesTree1HaveTree2(node1.left, node2.left) &&
                doesTree1HaveTree2(node1.right, node2.right);
    }

    // 18.二叉树的镜像
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        } else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    // 19.顺时针打印矩阵
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null)
            return list;
        int start = 0;
        while (matrix[0].length > start * 2 && matrix.length > start * 2) {
            printOneCircle(matrix, start, list);
            start++;
        }
        return list;
    }

    private void printOneCircle(int[][] matrix, int start, ArrayList<Integer> list) {
        int endX = matrix[0].length - 1 - start; // 列
        int endY = matrix.length - 1 - start;  // 行

        // 从左往右
        for (int i = start; i <= endX; ++i) {
            list.add(matrix[start][i]);
        }
        // 从上往下
        if (start < endY) {
            for (int i = start + 1; i <= endY; ++i) {
                list.add(matrix[i][endX]);
            }
        }
        // 从右往左（判断是否会重复打印）
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; --i) {
                list.add(matrix[endY][i]);
            }
        }
        // 从下往上（判断是否会重复打印）
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                list.add(matrix[i][start]);
            }
        }
    }

    // 20.包含min函数的栈
    /*
    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty()) {
            stack2.push(node);
        }else {
            if (stack2.peek() > node) {
                stack2.push(node);
            }
        }
    }

    public void pop() {
        if (stack1.pop() == stack2.peek()) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
    */

    // 21.栈的压入、弹出序列
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null)
            return false;

        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (int i = 0; i < pushA.length; ++i) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    // 22.从上往下打印二叉树
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return list;
    }

    // 23.二叉搜索树的后序遍历序列
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;

        int rStart = 0;
        int length = sequence.length;

        for (int i = 0; i < length - 1; ++i) {
            if (sequence[i] < sequence[length - 1])
                rStart++;
        }

        if (rStart == 0) {
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, length - 1));
        } else {
            for (int i = rStart; i < length - 1; ++i) {
                if (sequence[i] <= sequence[length - 1])
                    return false;
            }
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, rStart));
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, rStart, length - 1));
        }
        return true;
    }

    // 24.二叉树中和为某一值的路径
    private ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null)
            return resultList;

        list.add(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) {
            resultList.add(new ArrayList<>(list));
        } else {
            FindPath(root.left, target);
            FindPath(root.right, target);
        }
        //每返回上一层一次就要回退一个节点
        list.remove(list.size() - 1);
        return resultList;
    }

    // 25.复杂链表的复制
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;

        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode temp = head;

        while (pHead.next != null) {
            temp.next = new RandomListNode(pHead.next.label);
            if (pHead.random != null) {
                temp.random = new RandomListNode(pHead.random.label);
            }
            pHead = pHead.next;
            temp = temp.next;
        }

        return head;
    }

    // 26.二叉树搜索与双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;

        TreeNode left, right;
        TreeNode head = pRootOfTree;

        if (pRootOfTree.left != null) {
            left = Convert(pRootOfTree.left);
            head = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = pRootOfTree;
            pRootOfTree.left = left;
        }
        if (pRootOfTree.right != null) {
            right = Convert(pRootOfTree.right);
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }

        return head;
    }

    // 27.字符串的排列
    private ArrayList<String> result = new ArrayList<>();
    private TreeSet<String> temp = new TreeSet<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0)
            return result;
        char[] chars = str.toCharArray();
        Permutation(chars, 0);
        result.addAll(temp);
        return result;
    }

    private void Permutation(char[] chars, int index) {
        if (chars == null || chars.length == 0)
            return;
        if (index < 0 || index > chars.length - 1)
            return;
        if (index == chars.length - 1) {
            temp.add(String.valueOf(chars));
        } else {
            for (int i = index; i < chars.length; i++) {
                swap(chars, index, i);
                Permutation(chars, index + 1);
                // 回退
                swap(chars, index, i);
            }
        }
    }

    private void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    // 28.数组中出现超过一半的数字
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int maxCount = array[0];
        int number = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (number != array[i]) {
                if (count == 0) {
                    number = array[i];
                    count = 1;
                } else {
                    count--;
                }
            } else {
                count++;
            }

            if (count == 1) {
                maxCount = number;
            }
        }
        // 验证
        int num = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == maxCount) {
                num++;
            }
        }

        if (num * 2 > array.length) {
            return maxCount;
        }
        return 0;
    }

    // 29.最小的K个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null)
            return null;

        ArrayList<Integer> list = new ArrayList<>(k);
        if (k > input.length)
            return list;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            tree.add(input[i]);
        }
        int i = 0;
        for (Integer elem : tree) {
            if (i >= k)
                break;
            list.add(elem);
            i++;
        }
        return list;
    }

    // 30.连续子数组的最大和
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int cur = array[0];
        int greatest = array[0];

        for (int i = 1; i < array.length; i++) {
            if (cur < 0)
                cur = array[i];
            else
                cur += array[i];

            if (cur > greatest)
                greatest = cur;
        }
        return greatest;
    }

    // 31.整数中1出现的次数
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0; // 1的个数
        int i = 1;  // 当前位
        int current = 0, after = 0, before = 0;

        while ((n / i) != 0) {
            before = n / (i * 10); // 高位
            current = (n / i) % 10; // 当前位
            after = n - (n / i) * i;  // 低位

            if (current == 0)
                //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
                count = count + before * i;
            else if (current == 1)
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count = count + before * i + after + 1;
            else if (current > 1)
                // 如果大于1,出现1的次数由高位决定,（高位数字+1）* 当前位数
                count = count + (before + 1) * i;
            //前移一位
            i = i * 10;
        }
        return count;
    }

    // 32.把数组排成最小的数
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);            //也可用str[i] = "" + numbers[i];将整数数组转化为字符串数组
        }
		/*在基本数据中，compareTo()是比较两个Character 对象；
		在 Boolean中，是用boolean的实例于其它实例进行比较；
		在String 中，则是按照字典顺序进行比较，返回的值是一个int 型。*/
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);            //在String中，compareTo是按照字典顺序进行比较，返回的值是一个int型。
            }
        });
        for (int i = 0; i < len; i++) {
            stringbuilder.append(str[i]);
        }
        return stringbuilder.toString();
    }

    // 33.丑数
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int[] arr = new int[index];
        arr[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        for (int i = 1; i < index; i++) {
            int min = Math.min(arr[multiply2] * 2, Math.min(arr[multiply3] * 3, arr[multiply5] * 5));
            arr[i] = min;
            if (arr[multiply2] * 2 == min)
                multiply2++;
            if (arr[multiply3] * 3 == min)
                multiply3++;
            if (arr[multiply5] * 5 == min)
                multiply5++;
        }
        return arr[index - 1];
    }

    // 34.第一个只出现一次的字符
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;

        char[] c = str.toCharArray();
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();

        for (char item : c) {
            if (hashMap.containsKey(item))
                hashMap.put(item, hashMap.get(item) + 1);
            else
                hashMap.put(item, 1);
        }

        for (int i = 0; i < str.length(); ++i) {
            if (hashMap.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    // 35.数组中的逆序对
    int count = 0;

    public int InversePairs(int [] array) {
        if(array==null)
            return 0;
        mergeSort(array,0,array.length-1);
        return count;
    }

    private void mergeSort(int[] data,int start,int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(data, start, mid);            // 左边有序
            mergeSort(data, mid + 1, end);    // 右边有序
            merge(data, start, mid, end);           // 将两个有序数组合并
        }
    }

    // 将有二个有序数列data[start...mid]和data[mid...end]合并。
    public void merge(int[] data,int start,int mid,int end) {
        int arr[] = new int[end - start + 1];
        int c = 0;
        int s = start;
        int index = mid + 1;
        while (start <= mid && index <= end) {
            if (data[start] < data[index]) {
                // 左数组比右数组小
                arr[c++] = data[start++];
            } else {
                // 左数组比右数组大
                arr[c++] = data[index++];
                // 因为如果a[i]此时比右数组的当前元素a[j]大，
                // 那么左数组中a[i]后面的元素就都比a[j]大
                // 【因为数组此时是有序数组】
                count += mid +1 - start;
                count %= 1000000007;
            }
        }

        while (start <= mid) {
            arr[c++] = data[start++];
        }

        while (index <= end) {
            arr[c++] = data[index++];
        }

        for (int d : arr) {
            data[s++] = d;
        }
    }



}
