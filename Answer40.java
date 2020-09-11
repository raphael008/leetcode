import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Answer40 {
    public static List<List<Integer>> result;
    public static void main(String[] args) {
        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;

        combinationSum2(candidates, target);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        int[][] usedCandidates = new int[2][candidates.length];
        for (int i = 0; i < candidates.length; i++) {
            usedCandidates[0][i] = candidates[i];
            usedCandidates[1][i] = 0;

            if (candidates[i] > target)
                usedCandidates[1][i] = 2;
        }

        searching(candidates, target, usedCandidates);

        for (List<Integer> integers : result) {
            System.out.println(integers.stream()
                    .map(Objects::toString)
                    .collect(Collectors.joining(", ", "[", "]")));
        }

        return result;
    }

    public static void searching(int[] candidates, int target, int[][] usedCandidates) {
        if (target == 0) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < usedCandidates[1].length; i++) {
                if (usedCandidates[1][i] == 1)
                    integers.add(usedCandidates[0][i]);
            }

            if (!result.contains(integers))
                result.add(integers);

            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {

            // used candidates or candidates greater than target
            if (usedCandidates[1][i] == 1 || usedCandidates[1][i] == 2)
                continue;

            // greater than target
            if (candidates[i] > target) {
                continue;
            }

            usedCandidates[1][i] = 1;
            searching(candidates, target - candidates[i], usedCandidates);
            usedCandidates[1][i] = 0;
        }
    }
}