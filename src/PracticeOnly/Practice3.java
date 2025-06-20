package PracticeOnly;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Practice3 {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 1, 5, 2, 3, 2 };
		// sumSubArray(arr, 5);
		// longestSubArray(arr, 5);
		// subArrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100);

		// smallestSubArrayWithSumS(arr, 7);
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, 2, 1, 0, 4, 2, 6 }, 3)));
		firstNonRepeatingCharacter("aaaccaabbasfasfasfgasfas");
	}

	public static void firstNonRepeatingCharacter(String str) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println(entry.getKey());
				return;
			}
		}
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] res = new int[nums.length - k + 1];
		int l = 0;
		int r = 0;
		Deque<Integer> queue = new ArrayDeque<>();
		while (l <= r && r < nums.length) {
			while (!queue.isEmpty() && nums[queue.peekLast()] < nums[r]) {
				queue.pollLast();
			}
			queue.offerLast(r);
			if (queue.peekFirst() < l) {
				queue.pollFirst();
			}

			if (r - l + 1 == k) {
				res[l] = nums[queue.peekFirst()];
				l++;
			}
			r++;
		}
		return res;
	}

	public static String minWindow1(String s, String t) {
		HashMap<Character, Integer> needMap = new HashMap<>();
		HashMap<Character, Integer> haveMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			needMap.put(t.charAt(i), needMap.getOrDefault(t.charAt(i), 0) + 1);
		}
		int need = needMap.size();
		int have = 0;
		int l = 0;
		int min = Integer.MAX_VALUE;
		int[] res = new int[2];
		for (int r = 0; r < s.length(); r++) {
			char c = s.charAt(r);
			if (needMap.containsKey(c)) {
				haveMap.put(c, haveMap.getOrDefault(c, 0) + 1);
				if (haveMap.get(c) == needMap.get(c)) {
					have++;
				}
			}
			while (l <= r && have == need) {
				char removeC = s.charAt(l);
				if (haveMap.containsKey(removeC)) {
					haveMap.put(removeC, haveMap.getOrDefault(removeC, 0) - 1);
					if (haveMap.get(removeC) < needMap.get(removeC)) {
						have--;
					}
				}
				if (have == need && min > r - l + 1) {
					min = r - l + 1;
					res[0] = l;
					res[1] = r;
				}
				l++;
			}

		}
		StringBuilder sb = new StringBuilder("");
		for (int i = res[0]; i <= res[1]; i++) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public static void smallestSubArrayWithSumS(int arr[], int s) {
		int l = 0;
		int min = Integer.MAX_VALUE;
		int[] res = new int[2];
		int sum = 0;
		for (int r = 0; r < arr.length; r++) {
			sum += arr[r];

			while (sum >= s) {
				if (min > r - l + 1) {
					res[0] = l;
					res[1] = r;
					min = r - l + 1;
				}
				sum -= arr[l++];
			}

		}
		for (int m = res[0]; m <= res[1]; m++) {
			System.out.print(arr[m] + " ");
		}

	}

	public static void subArrayProductLessThanK(int arr[], int k) {
		int prod = 1;
		int left = 0;
		for (int right = 0; right < arr.length; right++) {
			prod *= arr[right];
			while (left <= right && prod >= k) {
				prod /= arr[left++];
			}
			for (int start = left; start <= right; start++) {
				for (int j = start; j <= right; j++) {
					System.out.print(arr[j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void majorityElement(int arr[]) {
		List<Integer> res = new ArrayList<>();
		int req = arr.length / 2;
		HashMap<Integer, Integer> freq = new HashMap<>();
		for (int i = 0; i < arr.length; i++)
			freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);

		for (int key : freq.keySet()) {
			if (freq.get(key) >= req) {
				res.add(key);
			}

		}
		System.out.println(res);
	}

	public static void longestSubArray(int arr[], int k) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		map.put(0, Arrays.asList(-1));
		int max = 0;
		int currentSum = 0;
		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];
			if (map.containsKey(currentSum - k)) {
				List<Integer> list = map.get(currentSum - k);
				for (int m : list) {
					max = Math.max(max, i - (m + 1) + 1);
				}
			}

			map.computeIfAbsent(currentSum, x -> new ArrayList<>()).add(i);
		}

		System.out.println("max array = " + max);
	}

	public static void sumSubArray(int[] arr, int k) {
		Map<Integer, List<Integer>> prefixMap = new HashMap<>();
		prefixMap.put(0, new ArrayList<>(Arrays.asList(-1))); // for subarrays starting at 0
		int currentSum = 0;
		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];
			if (prefixMap.containsKey(currentSum - k)) {
				for (int startindex : prefixMap.get(currentSum - k)) {
					System.out.println("start index = " + (startindex + 1) + " " + "endIndex " + i);
					for (int j = startindex + 1; j <= i; j++) {
						System.out.print(arr[j] + " ");
					}
				}
			}

			prefixMap.computeIfAbsent(currentSum, x -> new ArrayList<>()).add(i);
		}
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
