public class Answerqiu12nlcof {
    public static int result = 0;

    public static void main(String[] args) {
        // https://leetcode-cn.com/problems/qiu-12n-lcof/

        int n = 3;
        int result = sumNums(n);
        System.out.println(result);
    }

    public static int sumNums(int n) {
        result = result + n;
        boolean stopCondition = n > 0 && sumNums(n - 1) > 0;
        return result;
    }
}
