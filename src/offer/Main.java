package offer;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = new int[2][2];
        array[0][0] = 2;
        array[0][1] = 4;
        array[1][0] = 7;
        array[1][1] = 9;
        boolean result = solution.Find(7, array);
        System.out.println(result);
    }
}
