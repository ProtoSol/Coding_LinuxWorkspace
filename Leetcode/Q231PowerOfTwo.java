public class Q231PowerOfTwo {
    public static void main(String[] args) {
        int n = 16;
        Solution obj = new Solution();
        obj.isPowerOfTwo(n);
    }
}
class Solution {
    public void isPowerOfTwo(int n) {
        // return n > 0 && (n & (n - 1)) == 0;
        System.out.println(n > 0 && (n & (n - 1)) == 0);
    }
}
