package SlidingWindow;
//You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array. The window slides one position to the right until it reaches the right edge of the array.

//
//Return a list that contains the maximum element in the window at each step.
//
//Example 1:
//
//Input: nums = [1,2,1,0,4,2,6], k = 3
//
//Output: [2,2,4,4,6]
//
//Explanation: 
//Window position            Max
//---------------           -----
//[1  2  1] 0  4  2  6        2
// 1 [2  1  0] 4  2  6        2
// 1  2 [1  0  4] 2  6        4
// 1  2  1 [0  4  2] 6        4
// 1  2  1  0 [4  2  6]       6

import java.util.ArrayDeque;

public class SlidingWindowMaximum {
	// public int[] maxSlidingWindow(int[] nums, int k) {
//		System.out.println(Arrays.toString(nums));
//		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
//		int l = 0;
//		int r = 0;
//		int[] res = new int[nums.length - k + 1];
//		while (r < nums.length) {
//			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
//				deque.pollLast();
//			}
//			deque.offerLast(r);
//			if (deque.peekFirst() < l) {
//				deque.pollFirst();
//			}
//			if (r - l + 1 == k) {
//				res[l] = nums[deque.peekFirst()];
//				l++;
//			}
//			r++;
//		}
//		return res;
//	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		int l = 0;
		int[] res = new int[nums.length - k + 1];
		for (int r = 0; r < nums.length; r++) {
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
				deque.pollLast();
			}
			deque.offerLast(r);
			if (deque.peekFirst() < l) {
				deque.pollFirst();
			}
			if (r - l + 1 == k) {
				res[l] = nums[deque.peekFirst()];
				l++;
			}

		}
		return res;

	}
}
