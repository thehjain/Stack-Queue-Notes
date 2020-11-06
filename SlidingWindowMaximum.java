//Sliding Window Maximum is very famous algorithm
//to find the maximum element in current window of size k
//of given array.


//Basic approach give time complexity of O(n^2) using two
//loops.


//Efficeint approch is to use stack or deque.

import java.util.*;

class SlidingWindowMaximum {
	public static void main(String[] args) {

		int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
		int k = 3;

		printMax(arr, k);

	}

	static void printMax(int[] arr, int k) {

		Deque<Integer> st = new LinkedList<>();

		int i;
		for (i = 0; i < k; i++) {
			while (!st.isEmpty() && arr[i] >= arr[st.peekLast()])
				st.removeLast();
			st.addLast(i);
		}
		for (; i < arr.length; i++) {
			System.out.print(arr[st.peek()] + " ");

			while (!st.isEmpty() && st.peek() <= i - k)
				st.removeFirst();

			while (!st.isEmpty() && arr[i] >= arr[st.peekLast()])
				st.removeLast();

			st.addLast(i);
		}
		System.out.print(arr[st.peek()] + " ");
	}
}


//Problem is available on geeksforgeeks