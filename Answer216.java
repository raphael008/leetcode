import java.util.ArrayList;
import java.util.List;

public class Answer216 {
    public static List<Integer> temp = new ArrayList<>();
    public static List<List<Integer>> result = new ArrayList<>();

    public static int[] usedNums  = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static List<Integer> addedNums = new ArrayList<>();
    public static void main(String[] args) {
        // https://leetcode-cn.com/problems/combination-sum-iii/

        int k = 3;
        int n = 9;

        combinationSum3(k, n);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] > n)
                usedNums[i] = 2;
        }

        searching(k, n, arrays, usedNums);

        return result;
    }

    public static void searching(int k, int n, int[] array, int[] usedNumbers) {
        if (n < 0)
            return;

        if (k < 0)
            return;

        if (k == 0 && n == 0) {
            temp.clear();
            for (int i = 0; i < usedNumbers.length; i++) {
                if (usedNumbers[i] == 1) {
                    temp.add(array[i]);
                }
            }

            int sum = 1;
            for (Integer integer : temp) {
                sum = sum * integer;
            }

            if (!addedNums.contains(sum)){
                addedNums.add(sum);
                result.add(new ArrayList<>(temp));
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (usedNumbers[i] == 1 || usedNumbers[i] == 2) {
                continue;
            }

            usedNumbers[i] = 1;
            searching(k - 1, n - array[i], array, usedNumbers);
            usedNumbers[i] = 0;
        }
    }
}
