import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        return combinationSum(candidates, 0, target);

    }

    private List<List<Integer>> combinationSum(int[] candidates, int start, int target) {


        if (target < 0)
            return null;

        if (target == 0) {
            List<List<Integer>> temp = new ArrayList<>();
            List<Integer> temp1 = new ArrayList<>();
            temp.add(temp1);
            return temp;
        }

        if (start >= candidates.length)
            return null;


        List<List<Integer>> mainList = new ArrayList<>();
        int val = candidates[start];
        int originalVal = val;
        int count = 1;
        while (val <= target) {

            List<List<Integer>> tempList = combinationSum(candidates, start + 1, target - val);

            if (tempList != null) {
                for (List<Integer> list : tempList) {
                    for (int j = 0; j < count; j++)
                        list.add(originalVal);
                }
                mainList.addAll(tempList);
            }

            count++;
            val = val + originalVal;
        }

        List<List<Integer>> tempList = combinationSum(candidates, start + 1, target);

        if (tempList != null)
            mainList.addAll(tempList);

        return mainList;


    }

}
 