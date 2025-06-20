package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationII {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		getCombs(0, candidates, target, new ArrayList<>(), 0);
		return res;
	}

	public void getCombs(int i, int[] arr, int target, List<Integer> ans, int sum) {
		if (i >= arr.length) {
			if (sum == target) {
				List<Integer> list = new ArrayList<>();
				list.addAll(ans);
				res.add(list);
			}
			return;
		}

		ans.add(arr[i]);
		getCombs(i + 1, arr, target, ans, sum + arr[i]);
		ans.remove(ans.size() - 1);
		while (i + 1 < arr.length && arr[i] == arr[i + 1])
			i++;
		getCombs(i + 1, arr, target, ans, sum);
	}

}
