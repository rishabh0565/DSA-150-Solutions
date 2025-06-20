package Backtracking;

import java.util.ArrayList;
import java.util.List;

//Given an array nums of unique integers, return all possible subsets of nums.
//
//The solution set must not contain duplicate subsets. You may return the solution in any order.
//
//Example 1:
//
//Input: nums = [1,2,3]
//
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//Example 2:
//
//Input: nums = [7]
//
//Output: [[],[7]]
//Constraints:
//
//1 <= nums.length <= 10
//-10 <= nums[i] <= 10

public class Subsets {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		getSubsets(0, new ArrayList<>(), nums);
		return res;
	}

	public void getSubsets(int i, List<Integer> ans, int[] arr) {
		if (i >= arr.length) {
			List<Integer> a = new ArrayList<>();
			a.addAll(ans);
			res.add(a);
			return;
		}
		ans.add(arr[i]);
		getSubsets(i + 1, ans, arr);
		ans.remove(ans.size() - 1);
		getSubsets(i + 1, ans, arr);
	}
}
