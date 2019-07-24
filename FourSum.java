import java.util.*;


public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        return fourSum(nums, 0, 4, target);
    }


    public List<List<Integer>> fourSum(int[] nums, int begin, int k, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        if (k == 2) {
            int i = begin, j = nums.length - 1;
            while (i < j) {

                int sum = nums[i] + nums[j];

                if (sum == target && !visited.contains(nums[i])) {
                    visited.add(nums[i]);
                    List<Integer> branch = new ArrayList<>();
                    branch.add(nums[i]);
                    branch.add(nums[j]);
                    result.add(branch);
                    i++;
                    j--;
                } else if (sum < target) {
                    i++;
                } else { //sum > target
                    j--;
                }
            }

            return result;
        }


        for (int i = begin; i < nums.length; i++) {

            if (visited.contains(nums[i]))
                continue;

            visited.add(nums[i]);
            List<List<Integer>> list1 = fourSum(nums, i + 1, k - 1, target - nums[i]);

            if (list1.size() == 0)
                continue;

            for (List<Integer> list : list1)
                list.add(nums[i]);

            result.addAll(list1);

        }

        return result;
    }

}
