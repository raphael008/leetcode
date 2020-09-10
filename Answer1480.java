import java.util.Arrays;

public class Answer1480 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] result = runningSum(nums);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] runningSum(int[] nums) {
        int[] results = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                results[i] = nums[i];
                continue;
            }

            results[i] = results[i - 1] + nums[i];
        }

        return results;
    }
}