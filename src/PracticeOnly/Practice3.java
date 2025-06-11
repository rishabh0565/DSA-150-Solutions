package PracticeOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Practice3 {

	public static void main(String[] args) {
		System.out.println(minWindow("adobecodebanc", "abc"));
	}

	public static String minWindow(String s, String t) {
		HashMap<Character, Integer> freq2 = new HashMap<>();
		HashMap<Character, Integer> freq1 = new HashMap<>();
		if (t.length() > s.length())
			return "";
		for (char c : t.toCharArray())
			freq2.put(c, freq2.getOrDefault(c, 0) + 1);
		int have = 0;
		int need = freq2.size();

		int l = 0;
		int[] res = new int[] { 0, 0 };
		int min = Integer.MAX_VALUE;
		for (int r = 0; r < s.length(); r++) {
			char c = s.charAt(r);
			if (freq2.containsKey(c)) {
				freq1.put(c, freq1.getOrDefault(c, 0) + 1);

				if (freq1.get(c) == freq2.get(c))
					have++;

				while (have == need) {
					if (min > r - l + 1) {
						res[0] = l;
						res[1] = r;
						min = r - l + 1;
					}
					char m = s.charAt(l);
					if (freq1.containsKey(m)) {
						if (freq1.get(m) > 1) {
							freq1.put(m, freq1.getOrDefault(m, 0) - 1);
							if (freq1.get(m) != freq2.get(m)) {
								have--;
							}
						} else {
							freq1.remove(m);
							have--;
						}
					}

					l++;
				}
			}
		}
		return (min == Integer.MAX_VALUE) ? "" : s.substring(res[0], res[1] + 1);
	}

	public static boolean checkInclusion(String s1, String s2) {
		int[] freq1 = new int[26];
		int[] freq2 = new int[26];
		if (s1.length() > s2.length())
			return false;

		for (char c : s1.toCharArray())
			freq1[c - 'a']++;

		for (int r = 0; r < s2.length(); r++) {
			freq2[s2.charAt(r) - 'a']++;
			if (r >= s1.length()) {
				freq2[(s2.charAt(r - s1.length()) - 'a')]--;
			}
			if (Arrays.equals(freq1, freq2))
				return true;
		}
		return false;
	}

	public static int characterReplacement(String s, int k) {
		HashMap<Character, Integer> freq = new HashMap<>();

		if (s.equals(""))
			return 0;

		int l = 0;
		int r = 0;
		String substring = s.substring(l, r + 1);
		for (char c : substring.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		r++;
		int maxRes = 0;
		while (l <= r && r < s.length()) {

			if (r - l + 1 - maxFreq(freq) <= k) {
				if (!freq.containsKey(s.charAt(r))) {
					freq.put(s.charAt(r), 1);
				} else {
					freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
				}
				maxRes = Math.max(maxRes, r - l + 1);
				r++;
			} else {
				if (freq.containsKey(s.charAt(l))) {

					if (freq.get(s.charAt(l)) != null && freq.get(s.charAt(l)) > 1) {

						freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
					}
				}

				else {
					freq.remove(s.charAt(l));
				}
				maxRes = Math.max(maxRes, r - l + 1);
				l++;

			}
		}

		return maxRes;

	}

	public static int maxFreq(HashMap<Character, Integer> map) {
		int max = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			max = Math.max(max, entry.getValue());
		}
		return max;
	}

	public static int findMin(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			if (nums[l] < nums[r]) {
				break;
			}
			int mid = l + (r - l) / 2;
			if (nums[mid] >= nums[l]) {
				l = mid + 1;
			} else if (nums[mid] > nums[mid - 1])
				r = mid - 1;
		}
		return nums[l];
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int top = 0;
		int bottom = matrix.length - 1;
		int mid = top + (bottom - top) / 2;
		while (top <= bottom) {
			mid = top + (bottom - top) / 2;
			if (matrix[mid][matrix.length - 1] < target) {
				top = mid + 1;
			} else if (matrix[mid][matrix.length - 1] > target) {
				bottom = mid - 1;
			} else {
				break;
			}
		}

		int l = 0;
		int r = matrix[mid].length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (matrix[mid][m] > target) {
				r = m - 1;
			} else if (matrix[mid][m] < target) {
				l = m + 1;
			} else {
				return true;
			}
		}
		return false;
	}

	public static int largestRectangle(int[] graph) {
		int max = 0;
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < graph.length; i++) {
			int start = i;
			while (!stack.isEmpty() && stack.peek()[0] > graph[i]) {
				int[] popped = stack.pop();
				int h = popped[0];
				int index = popped[1];
				max = Math.max(h * (i - index), max);
				start = index;
			}
			stack.push(new int[] { graph[i], start });
		}

		while (!stack.isEmpty()) {
			int[] pop = stack.pop();
			max = Math.max(max, pop[0] * (graph.length - pop[1]));
		}

		return max;
	}

	public static void generateParanthesis(List<String> res, int open, int close, int n, StringBuilder sb) {
		if (open == n && close == n) {
			res.add(sb.toString());
			return;
		}
		if (open < n) {
			sb.append("(");
			generateParanthesis(res, open + 1, close, n, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (close < open) {
			sb.append(")");
			generateParanthesis(res, open, close + 1, n, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		HashMap<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
		for (char c : s.toCharArray()) {

			if (map.containsKey(c) && stack.isEmpty()) {
				return false;
			} else if (map.containsKey(c)) {
				char pop = stack.pop();
				if (map.get(c) != pop) {
					return false;
				}
			} else {
				stack.push(c);
			}

		}
		return stack.isEmpty();
	}

	public static int[] topKFrequent(int[] nums, int k) {
		ArrayList<Integer>[] freq = new ArrayList[nums.length + 1];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for (int i = 0; i <= nums.length; i++) {
			freq[i] = new ArrayList<>();
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			freq[value].add(entry.getKey());
		}
		int[] res = new int[k];
		int resIndex = 0;
		for (int i = freq.length - 1; i >= 0 && resIndex < k; i--) {
			for (int num : freq[i]) {
				if (resIndex < k) {
					res[resIndex++] = num;
				}
			}
		}
		return res;
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(target - nums[i], i);
			} else {
				return new int[] { map.get(nums[i]), i };
			}
		}
		return new int[] { 0, 0 };
	}

	public static boolean isAnagram(String s, String t) {
		HashMap<Character, Integer> freq1 = new HashMap<>();
		HashMap<Character, Integer> freq2 = new HashMap<>();
		for (char c : s.toCharArray()) {
			freq1.put(c, freq1.getOrDefault(c, 0) + 1);
		}
		for (char c : t.toCharArray()) {
			freq2.put(c, freq2.getOrDefault(c, 0) + 1);
		}
		if (freq1.size() != freq2.size()) {
			return false;
		}
		for (Map.Entry<Character, Integer> entry : freq1.entrySet()) {
			char c = entry.getKey();
			int val = entry.getValue();
			if (!freq2.containsKey(c))
				return false;
			else {
				if (freq2.get(c) != val) {
					return false;
				}
			}
		}
		return true;

	}

}
